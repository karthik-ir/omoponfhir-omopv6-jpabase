/*******************************************************************************
 * Copyright (c) 2019 Georgia Tech Research Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *******************************************************************************/
package edu.gatech.chai.omopv6.dba.service;

import edu.gatech.chai.omopv6.jpa.dao.RadiationDao;
import edu.gatech.chai.omopv6.model.entity.Radiation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.gatech.chai.omopv6.jpa.dao.ProcedureOccurrenceDao;
import edu.gatech.chai.omopv6.model.entity.ProcedureOccurrence;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcedureOccurrenceServiceImp.
 */
@Service
public class ProcedureOccurrenceServiceImp extends BaseEntityServiceImp<ProcedureOccurrence, ProcedureOccurrenceDao>
		implements ProcedureOccurrenceService {

	@Autowired
	private RadiationDao radiationDao;
	/**
	 * Instantiates a new procedure occurrence service imp.
	 */
	public ProcedureOccurrenceServiceImp() {
		super(ProcedureOccurrence.class);
	}

	@Override
	public Long getSize(List<ParameterWrapper> paramList) {
		EntityManager em = this.getEntityDao().getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<ProcedureOccurrence> root = query.from(this.getEntityClass());

		List<Predicate> predicates = ParameterWrapper.constructPredicate(builder, paramList, root);
		if (predicates == null || predicates.isEmpty()) return 0L;

		query.select(builder.count(root));
		query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		Long procedureOccuranceCount = em.createQuery(query).getSingleResult();
		if(procedureOccuranceCount ==0){
			em = this.radiationDao.getEntityManager();
			builder = em.getCriteriaBuilder();
			query = builder.createQuery(Long.class);
			Root<Radiation> r2 = query.from(Radiation.class);
			predicates = ParameterWrapper.constructPredicate(builder, paramList, root);
			if (predicates == null || predicates.isEmpty()) return 0L;
			query.select(builder.count(root));
			query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			Long radiationCount = em.createQuery(query).getSingleResult();
			return radiationCount;
		}else {
			return procedureOccuranceCount;
		}
	}

	@Override
	public List<ProcedureOccurrence> searchWithParams(int fromIndex, int toIndex, List<ParameterWrapper> paramList, String sort) {
		int length = toIndex - fromIndex;
		EntityManager em = this.getEntityDao().getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ProcedureOccurrence> query = builder.createQuery(ProcedureOccurrence.class);
		Root<ProcedureOccurrence> root = query.from(ProcedureOccurrence.class);

		List<ProcedureOccurrence> retvals = new ArrayList<ProcedureOccurrence>();

		List<Predicate> predicates = ParameterWrapper.constructPredicate(builder, paramList, root);
		if (predicates == null || predicates.isEmpty()) return retvals; // Nothing. return empty list

		query.select(root);
		query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		// Sort
		if (sort != null) {
			query.orderBy(addSort(builder, root, sort));
		}

		if (length <= 0) {
			retvals = em.createQuery(query)
					.getResultList();
		} else {
			retvals = em.createQuery(query)
					.setFirstResult(fromIndex)
					.setMaxResults(length)
					.getResultList();
		}
		if(retvals.size()==0){
			em = this.radiationDao.getEntityManager();
			builder = em.getCriteriaBuilder();
			CriteriaQuery<Radiation> q1 = builder.createQuery(Radiation.class);
			Root<Radiation> r2 = q1.from(Radiation.class);
			predicates = ParameterWrapper.constructPredicate(builder, paramList, root);
			if (predicates == null || predicates.isEmpty()) return retvals; // Nothing. return empty list
			q1.select(r2);
			q1.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			if (sort != null) {
				q1.orderBy(addSort(builder, root, sort));
			}
			List<Radiation> radiationVals = new ArrayList<Radiation>();;
			if (length <= 0) {
				radiationVals = em.createQuery(q1)
						.getResultList();
			} else {
				radiationVals = em.createQuery(q1)
						.setFirstResult(fromIndex)
						.setMaxResults(length)
						.getResultList();
			}
			//TODO: Map Radiation to procedure occurance obj
			for(Radiation r: radiationVals) {
				ProcedureOccurrence x = new ProcedureOccurrence();
				BeanUtils.copyProperties( radiationVals.get(0),x);
				retvals.add(x);
			}
		}
		return retvals;

	}
}
