package com.company.accumed.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "ACCUMED_CLAIM_LINE")
@Entity(name = "accumed$ClaimLine")
public class ClaimLine extends StandardEntity {
    private static final long serialVersionUID = 4845469563797518807L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLAIM_ID")
    protected Claim claim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICE_CODE_ID")
    protected BillableServiceCode serviceCode;

    @Column(name = "DIAGNOSTIC_CODE")
    protected String diagnosticCode;

    @Column(name = "NO_OF_SERVICES")
    protected Integer noOfServices;

    @Column(name = "FEE")
    protected Double fee;

    @Temporal(TemporalType.DATE)
    @Column(name = "SERVICE_DATE")
    protected Date serviceDate;

    public BillableServiceCode getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(BillableServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }


    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setDiagnosticCode(String diagnosticCode) {
        this.diagnosticCode = diagnosticCode;
    }

    public String getDiagnosticCode() {
        return diagnosticCode;
    }

    public void setNoOfServices(Integer noOfServices) {
        this.noOfServices = noOfServices;
    }

    public Integer getNoOfServices() {
        return noOfServices;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getFee() {
        return fee;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    @Transient
    public Gender getPatientGender() {
        return claim.getPatientGender();
    }

    @Transient
    public Provider getReferredBy() {
        return claim.getReferredBy();
    }

    @Transient
    public Facility getFacilityNumber() {
        return claim.getFacility();
    }

    @Transient
    public Date getAdmitDate() {
        return claim.getAdmitDate();
    }

    @Transient
    public int getPatientAge() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");  //kludgy way to get year!
        return (serviceDate != null) ? Integer.parseInt(df.format(serviceDate)) - claim.getPatientBirthYear() : 0;
    }

    @Transient
    public boolean getManualReview() {
        return claim.getManualReview();
    }
}