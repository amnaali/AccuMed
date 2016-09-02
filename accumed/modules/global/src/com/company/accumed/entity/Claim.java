package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.OneToMany;

@Table(name = "ACCUMED_CLAIM")
@Entity(name = "accumed$Claim")
public class Claim extends StandardEntity {
    private static final long serialVersionUID = 3994645370435435933L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    protected Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REFERRED_BY_ID")
    protected Provider referredBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVIDER_ID")
    protected Provider provider;

    @Column(name = "CLAIM_TYPE")
    protected Integer claimType;

    @Column(name = "LOCATION")
    protected String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACILITY_ID")
    protected Facility facility;

    @Temporal(TemporalType.DATE)
    @Column(name = "ADMIT_DATE")
    protected Date admitDate;

    @Column(name = "REFERRING_LAB")
    protected String referringLab;

    @Column(name = "MANUAL_REVIEW")
    protected Boolean manualReview;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "claim")
    protected Set<ClaimLine> claimLine;

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Provider getProvider() {
        return provider;
    }


    public ClaimType getClaimType() {
        return claimType == null ? null : ClaimType.fromId(claimType);
    }

    public void setClaimType(ClaimType claimType) {
        this.claimType = claimType == null ? null : claimType.getId();
    }


    public Boolean getManualReview() {
        return manualReview;
    }

    public void setManualReview(Boolean manualReview) {
        this.manualReview = manualReview;
    }


    public void setClaimLine(Set<ClaimLine> claimLine) {
        this.claimLine = claimLine;
    }

    public Set<ClaimLine> getClaimLine() {
        return claimLine;
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setReferredBy(Provider referredBy) {
        this.referredBy = referredBy;
    }

    public Provider getReferredBy() {
        return referredBy;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setAdmitDate(Date admitDate) {
        this.admitDate = admitDate;
    }

    public Date getAdmitDate() {
        return admitDate;
    }

    public void setReferringLab(String referringLab) {
        this.referringLab = referringLab;
    }

    public String getReferringLab() {
        return referringLab;
    }


}