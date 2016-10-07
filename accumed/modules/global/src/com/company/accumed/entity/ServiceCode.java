package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.OneToMany;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;

@Table(name = "ACCUMED_SERVICE_CODE")
@Entity(name = "accumed$ServiceCode")
public class ServiceCode extends StandardEntity {
    private static final long serialVersionUID = -918370950814937081L;

    @Column(name = "SERVICE_CODE", nullable = false, unique = true, length = 10)
    protected String serviceCode;

    @Column(name = "DESCRIPTION", nullable = false)
    protected String description;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "serviceCode")
    protected Set<ServiceCodeRule> rules;

    @Composition
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "serviceCode")
    protected Set<BillableServiceCode> billableCodes;

    public void setBillableCodes(Set<BillableServiceCode> billableCodes) {
        this.billableCodes = billableCodes;
    }

    public Set<BillableServiceCode> getBillableCodes() {
        return billableCodes;
    }


    public void setRules(Set<ServiceCodeRule> rules) {
        this.rules = rules;
    }

    public Set<ServiceCodeRule> getRules() {
        return rules;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }


}