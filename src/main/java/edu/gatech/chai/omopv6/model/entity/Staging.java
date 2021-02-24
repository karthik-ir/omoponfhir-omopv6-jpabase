package edu.gatech.chai.omopv6.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name="staging",
        indexes = {
                @Index(name = "idx_stage_group_concept_id", columnList = "stage_group_concept_id"),
                @Index(name = "idx_staging_fperson_id", columnList = "person_id")
        }
)
public class Staging extends BaseEntity {
    @Id
    @Column(name = "observation_id")
    @Access(AccessType.PROPERTY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private FPerson fPerson;

    @ManyToOne
    @JoinColumn(name="stage_class_concept_id", nullable=false)
    private Concept stageClassConcept;

    @ManyToOne
    @JoinColumn(name="stage_class_source_concept_id", nullable=false)
    private Concept stageClassSourceConcept;

    @Column(name = "stage_date")
    @Temporal(TemporalType.DATE)
    private Date stageDate;

    @Column(name = "stage_datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date stageDateTime;

    @ManyToOne
    @JoinColumn(name="stage_group_concept_id", nullable=false)
    private Concept stageGroupConcept;

    @ManyToOne
    @JoinColumn(name="stage_group_source_concept_id", nullable=false)
    private Concept stageGroupSourceConcept;

    @ManyToOne
    @JoinColumn(name = "tstage_concept_id")
    private Concept tstageConcept;

    @ManyToOne
    @JoinColumn(name="tstage_source_concept_id", nullable=false)
    private Concept tstageSourceConcept;

    @ManyToOne
    @JoinColumn(name = "nstage_concept_id")
    private Concept nstageConcept;

    @ManyToOne
    @JoinColumn(name="nstage_source_concept_id", nullable=false)
    private Concept nstageSourceConcept;

    @ManyToOne
    @JoinColumn(name = "mstage_concept_id")
    private Concept mstageConcept;

    @ManyToOne
    @JoinColumn(name="mstage_source_concept_id", nullable=false)
    private Concept mstageSourceConcept;

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

    public Concept getStageClassConcept() {
        return stageClassConcept;
    }

    public void setStageClassConcept(Concept stageClassConcept) {
        this.stageClassConcept = stageClassConcept;
    }

    public Concept getStageClassSourceConcept() {
        return stageClassSourceConcept;
    }

    public void setStageClassSourceConcept(Concept stageClassSourceConcept) {
        this.stageClassSourceConcept = stageClassSourceConcept;
    }

    public Date getStageDate() {
        return stageDate;
    }

    public void setStageDate(Date stageDate) {
        this.stageDate = stageDate;
    }

    public Date getStageDateTime() {
        return stageDateTime;
    }

    public void setStageDateTime(Date stageDateTime) {
        this.stageDateTime = stageDateTime;
    }

    public Concept getStageGroupConcept() {
        return stageGroupConcept;
    }

    public void setStageGroupConcept(Concept stageGroupConcept) {
        this.stageGroupConcept = stageGroupConcept;
    }

    public Concept getStageGroupSourceConcept() {
        return stageGroupSourceConcept;
    }

    public void setStageGroupSourceConcept(Concept stageGroupSourceConcept) {
        this.stageClassSourceConcept = stageGroupSourceConcept;
    }

    public Concept getTstageConcept() {
        return tstageConcept;
    }

    public void setTstageConcept(Concept tstageConcept) {
        this.tstageConcept = tstageConcept;
    }

    public Concept getTstageSourceConcept() {
        return tstageSourceConcept;
    }

    public void setTstageSourceConcept(Concept tstageSourceConcept) {
        this.tstageSourceConcept = tstageSourceConcept;
    }

    public Concept getNstageConcept() {
        return nstageConcept;
    }

    public void setNstageConcept(Concept nstageConcept) {
        this.nstageConcept = nstageConcept;
    }

    public Concept getNstageSourceConcept() {
        return nstageSourceConcept;
    }

    public void setNstageSourceConcept(Concept nstageSourceConcept) {
        this.nstageSourceConcept = nstageSourceConcept;
    }

    public Concept getMstageConcept() {
        return mstageConcept;
    }

    public void setMstageConcept(Concept mstageConcept) {
        this.mstageConcept = mstageConcept;
    }

    public Concept getMstageSourceConcept() {
        return mstageSourceConcept;
    }

    public void setMstageSourceConcept(Concept mstageSourceConcept) {
        this.mstageSourceConcept = mstageSourceConcept;
    }

    @Override
    public Long getIdAsLong() {
        return getId();
    }
}
