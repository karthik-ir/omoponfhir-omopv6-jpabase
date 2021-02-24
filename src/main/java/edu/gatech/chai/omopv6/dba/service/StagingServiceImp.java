package edu.gatech.chai.omopv6.dba.service;

import edu.gatech.chai.omopv6.jpa.dao.StagingDao;
import edu.gatech.chai.omopv6.model.entity.Staging;
import org.springframework.stereotype.Service;

@Service
public class StagingServiceImp extends BaseEntityServiceImp<Staging, StagingDao> implements StagingService{

    public StagingServiceImp() {
        super(Staging.class);
    }
}
