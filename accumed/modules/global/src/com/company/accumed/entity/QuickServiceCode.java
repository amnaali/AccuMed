package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Lob;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Table(name = "ACCUMED_QUICK_SERVICE_CODE")
@Entity(name = "accumed$QuickServiceCode")
public class QuickServiceCode extends StandardEntity {
    private static final long serialVersionUID = 2484453302922757149L;

    @Column(name = "QUICK_CODE", nullable = false, unique = true)
    protected String quickCode;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @Column(name = "NUMBER_OF_SERVICES")
    protected Integer numberOfServices;

    @Column(name = "DIAGNOSTIC_CODE")
    protected String diagnosticCode;

    @Column(name = "PERCENTAGE_OF_FEE")
    protected Integer percentageOfFee;

    @Column(name = "DEFAULT_CODE")
    protected Boolean defaultCode;


    @JoinTable(name = "ACCUMED_QUICK_SERVICE_CODE_BILLABLE_SERVICE_CODE_LINK",
        joinColumns = @JoinColumn(name = "QUICK_SERVICE_CODE_ID"),
        inverseJoinColumns = @JoinColumn(name = "BILLABLE_SERVICE_CODE_ID"))
    @ManyToMany
    @OnDelete(DeletePolicy.CASCADE)
    protected Set<BillableServiceCode> serviceCodes;

    public Set<BillableServiceCode> getServiceCodes() {
        return serviceCodes;
    }

    public void setServiceCodes(Set<BillableServiceCode> serviceCodes) {
        this.serviceCodes = serviceCodes;
    }



    public void setQuickCode(String quickCode) {
        this.quickCode = quickCode;
    }

    public String getQuickCode() {
        return quickCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setNumberOfServices(Integer numberOfServices) {
        this.numberOfServices = numberOfServices;
    }

    public Integer getNumberOfServices() {
        return numberOfServices;
    }

    public void setDiagnosticCode(String diagnosticCode) {
        this.diagnosticCode = diagnosticCode;
    }

    public String getDiagnosticCode() {
        return diagnosticCode;
    }

    public void setPercentageOfFee(Integer percentageOfFee) {
        this.percentageOfFee = percentageOfFee;
    }

    public Integer getPercentageOfFee() {
        return percentageOfFee;
    }

    public void setDefaultCode(Boolean defaultCode) {
        this.defaultCode = defaultCode;
    }

    public Boolean getDefaultCode() {
        return defaultCode;
    }


}