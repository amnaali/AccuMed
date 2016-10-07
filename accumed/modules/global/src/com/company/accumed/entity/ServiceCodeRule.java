package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|ruleName")
@Table(name = "ACCUMED_SERVICE_CODE_RULE")
@Entity(name = "accumed$ServiceCodeRule")
public class ServiceCodeRule extends StandardEntity {
    private static final long serialVersionUID = -8592037110677236910L;

    @Column(name = "RULE_NAME")
    protected String ruleName;

    @Column(name = "PROPERTY_NAME", nullable = false)
    protected String propertyName;

    @Column(name = "PROPERTY_VALUE")
    protected String propertyValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICE_CODE_ID")
    protected ServiceCode serviceCode;

    @Column(name = "RULE_OPERATOR", nullable = false)
    protected String ruleOperator;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }


    public String getRuleOperator() {
        return ruleOperator;
    }

    public void setRuleOperator(String ruleOperator) {
        this.ruleOperator = ruleOperator;
    }





    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    public ServiceCode getServiceCode() {
        return serviceCode;
    }


    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyValue() {
        return propertyValue;
    }



}