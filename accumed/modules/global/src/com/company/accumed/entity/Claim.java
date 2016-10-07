package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
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
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Set;
import javax.persistence.OneToMany;
import com.haulmont.chile.core.annotations.MetaProperty;
import javax.persistence.Transient;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s : %s : %s|patient,provider,admitDate")
@Table(name = "ACCUMED_CLAIM")
@Entity(name = "accumed$Claim")
public class Claim extends StandardEntity {
    private static final long serialVersionUID = 3994645370435435933L;

    @ManyToOne
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

    @Transient
    @MetaProperty
    protected String lastModified;

    public  void setLastModified(String lastModified) {
    }

    @Transient
    public  String getLastModified() {
        if (createTs == null) {
            return createdBy;
        }
        return StringUtils.isEmpty(updatedBy) ?  createdBy + " : [" + DateFormatUtils.format(createTs, "MM/dd/yyyy hh:mm") +"]":
                updatedBy + " : [" + DateFormatUtils.format(updateTs, "MM/dd/yyyy hh:mm") +"]";
    }

    @Transient
    public Gender getPatientGender() {
        return patient.getGender();
    }

    @Transient
    public int getPatientBirthYear() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        return (patient != null && patient.getBirthDate() != null) ? Integer.parseInt(df.format(patient.getBirthDate())) : 9999;
    }

    public  void setProvider(Provider provider) {
        this.provider = provider;
    }

    public  Provider getProvider() {
        return provider;
    }


    public  ClaimType getClaimType() {
        return claimType == null ? null : ClaimType.fromId(claimType);
    }

    public  void setClaimType(ClaimType claimType) {
        this.claimType = claimType == null ? null : claimType.getId();
    }


    public  Boolean getManualReview() {
        return manualReview;
    }

    public  void setManualReview(Boolean manualReview) {
        this.manualReview = manualReview;
    }


    public  void setClaimLine(Set<ClaimLine> claimLine) {
        this.claimLine = claimLine;
    }

    public  Set<ClaimLine> getClaimLine() {
        return claimLine;
    }


    public  void setPatient(Patient patient) {
        this.patient = patient;
    }

    public  Patient getPatient() {
        return patient;
    }

    public  void setReferredBy(Provider referredBy) {
        this.referredBy = referredBy;
    }

    public  Provider getReferredBy() {
        return referredBy;
    }

    public  void setLocation(String location) {
        this.location = location;
    }

    public  String getLocation() {
        return location;
    }

    public  void setFacility(Facility facility) {
        this.facility = facility;
    }

    public  Facility getFacility() {
        return facility;
    }

    public  void setAdmitDate(Date admitDate) {
        this.admitDate = admitDate;
    }

    public  Date getAdmitDate() {
        return admitDate;
    }

    public  void setReferringLab(String referringLab) {
        this.referringLab = referringLab;
    }

    public  String getReferringLab() {
        return referringLab;
    }

 
}