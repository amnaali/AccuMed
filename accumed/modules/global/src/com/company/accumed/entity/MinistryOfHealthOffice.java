package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|officeCity")
@Table(name = "ACCUMED_MINISTRY_OF_HEALTH_OFFICE")
@Entity(name = "accumed$MinistryOfHealthOffice")
public class MinistryOfHealthOffice extends StandardEntity {
    private static final long serialVersionUID = -9094879108431141786L;

    @Column(name = "OFFICE_CODE", nullable = false, unique = true, length = 5)
    protected String officeCode;

    @Column(name = "OFFICE_CITY", nullable = false, length = 100)
    protected String officeCity;

    @Column(name = "CLAIM_CARD_CODE", length = 5)
    protected String claimCardCode;

    public void setOfficeCity(String officeCity) {
        this.officeCity = officeCity;
    }

    public String getOfficeCity() {
        return officeCity;
    }


    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setClaimCardCode(String claimCardCode) {
        this.claimCardCode = claimCardCode;
    }

    public String getClaimCardCode() {
        return claimCardCode;
    }


}