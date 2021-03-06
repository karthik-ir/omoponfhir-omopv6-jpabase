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
package edu.gatech.chai.omopv6.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
		name="radiation",
		indexes = { 
				@Index(name = "idx_procedure_concept_id", columnList = "modality_concept_id"),
				@Index(name = "idx_procedure_fperson_id", columnList = "person_id")
				}
		)
public class Radiation extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="procedure_occurrence_seq_gen")
	@SequenceGenerator(name="procedure_occurrence_seq_gen", sequenceName="procedure_occurrence_id_seq", allocationSize=1)
	@Column(name = "observation_id")
	@Access(AccessType.PROPERTY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private FPerson fPerson;

	@ManyToOne
	@JoinColumn(name = "modality_concept_id")
	private Concept procedureConcept;

	@Column(name = "rad_start_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date procedureDate;

	@Column(name = "rad_start_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date procedureDateTime;

	//FIXME: this is a wrong mapping
	@ManyToOne
	@JoinColumn(name = "dose_unit_concept_id", nullable = false)
	private Concept procedureTypeConcept;

	@ManyToOne
	@Transient
	@JoinColumn(name = "modifier_concept_id")
	private Concept modifierConcept;

	//FIXME: this is a wrong mapping
	@Column(name="total_dose")
	@Transient
	private Long quantity;

	@ManyToOne
	@Transient
	@JoinColumn(name = "provider_id")
	private Provider provider;

	@ManyToOne
	@Transient
	@JoinColumn(name = "visit_occurrence_id")
	private VisitOccurrence visitOccurrence;

	@ManyToOne
	@Transient
	@JoinColumn(name = "visit_detail_id")
	private VisitDetail visitDetail;

	//FIXME: this is a wrong mapping
	@Column(name = "src_tracing_id")
	private String procedureSourceValue;

	@ManyToOne
	@JoinColumn(name = "modality_source_concept_id")
	private Concept procedureSourceConcept;

	@Column(name = "modifier_source_value")
	@Transient
	private String modifierSourceValue;

	public Radiation() {
		super();
	}

	public Radiation(Long id) {
		super();
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FPerson getFPerson() {
		return fPerson;
	}

	public void setFPerson(FPerson fPerson) {
		this.fPerson = fPerson;
	}

	public Concept getProcedureConcept() {
		return procedureConcept;
	}

	public void setProcedureConcept(Concept procedureConcept) {
		this.procedureConcept = procedureConcept;
	}

	public Date getProcedureDate() {
		return procedureDate;
	}

	public void setProcedureDate(Date procedureDate) {
		this.procedureDate = procedureDate;
	}

	public Date getProcedureDateTime() {
		return procedureDateTime;
	}

	public void setProcedureDateTime(Date procedureDateTime) {
		this.procedureDateTime = procedureDateTime;
	}

	public Concept getProcedureTypeConcept() {
		return procedureTypeConcept;
	}

	public void setProcedureTypeConcept(Concept procedureTypeConcept) {
		this.procedureTypeConcept = procedureTypeConcept;
	}

	public Concept getModifierConcept() {
		return modifierConcept;
	}
	
	public void setModifierConcept(Concept modifierConcept) {
		this.modifierConcept = modifierConcept;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public VisitOccurrence getVisitOccurrence() {
		return visitOccurrence;
	}

	public void setVisitOccurrence(VisitOccurrence visitOccurrence) {
		this.visitOccurrence = visitOccurrence;
	}

	public VisitDetail getVisitDetail() {
		return visitDetail;
	}

	public void setVisitDetail(VisitDetail visitDetail) {
		this.visitDetail = visitDetail;
	}

	public String getProcedureSourceValue() {
		return procedureSourceValue;
	}

	public void setProcedureSourceValue(String procedureSourceValue) {
		this.procedureSourceValue = procedureSourceValue;
	}

	public Concept getProcedureSourceConcept() {
		return procedureSourceConcept;
	}

	public void setProcedureSourceConcept(Concept procedureSourceConcept) {
		this.procedureSourceConcept = procedureSourceConcept;
	}

	public String getModifierSourceValue() {
		return modifierSourceValue;
	}
	
	public void setModifierSourceValue(String modifierSourceValue) {
		this.modifierSourceValue = modifierSourceValue;
	}

	@Override
	public Long getIdAsLong() {
		return getId();
	}

}
