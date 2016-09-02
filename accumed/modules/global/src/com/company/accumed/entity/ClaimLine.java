package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Table(name = "ACCUMED_CLAIM_LINE")
@Entity(name = "accumed$ClaimLine")
public class ClaimLine extends StandardEntity {
    private static final long serialVersionUID = 4845469563797518807L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLAIM_ID")
    protected Claim claim;

    @Column(name = "SERVICE_CODE")
    protected String serviceCode;

    @Column(name = "DIAGNOSTIC_CODE")
    protected String diagnosticCode;

    @Column(name = "NO_OF_SERVICES")
    protected Integer noOfServices;

    @Column(name = "FEE")
    protected Double fee;

    @Temporal(TemporalType.DATE)
    @Column(name = "SERVICE_DATE")
    protected Date serviceDate;

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public Claim getClaim() {
        return claim;
    }


    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceCode() {
        return serviceCode;
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


}