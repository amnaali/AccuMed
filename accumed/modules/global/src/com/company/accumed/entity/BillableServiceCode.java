package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Table(name = "ACCUMED_BILLABLE_SERVICE_CODE")
@Entity(name = "accumed$BillableServiceCode")
public class BillableServiceCode extends StandardEntity {
    private static final long serialVersionUID = -8231910228779149562L;

    @Column(name = "BILLABLE_CODE", nullable = false, unique = true)
    protected String billableCode;

    @Column(name = "CODE_TYPE", nullable = false)
    protected String codeType;

    @Column(name = "FEE", nullable = false)
    protected Double fee;

    @Column(name = "UNITS", nullable = false)
    protected Double units;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICE_CODE_ID")
    protected ServiceCode serviceCode;



    @JoinTable(name = "ACCUMED_QUICK_SERVICE_CODE_BILLABLE_SERVICE_CODE_LINK",
        joinColumns = @JoinColumn(name = "BILLABLE_SERVICE_CODE_ID"),
        inverseJoinColumns = @JoinColumn(name = "QUICK_SERVICE_CODE_ID"))
    @ManyToMany
    protected Set<QuickServiceCode> quickServiceCodes;

    public void setQuickServiceCodes(Set<QuickServiceCode> quickServiceCodes) {
        this.quickServiceCodes = quickServiceCodes;
    }

    public Set<QuickServiceCode> getQuickServiceCodes() {
        return quickServiceCodes;
    }



    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    public ServiceCode getServiceCode() {
        return serviceCode;
    }


    public void setCodeType(BillableCodeType codeType) {
        this.codeType = codeType == null ? null : codeType.getId();
    }

    public BillableCodeType getCodeType() {
        return codeType == null ? null : BillableCodeType.fromId(codeType);
    }


    public void setBillableCode(String billableCode) {
        this.billableCode = billableCode;
    }

    public String getBillableCode() {
        return billableCode;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getFee() {
        return fee;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public Double getUnits() {
        return units;
    }


}