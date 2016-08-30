package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|facilityName")
@Table(name = "ACCUMED_FACILITY")
@Entity(name = "accumed$Facility")
public class Facility extends StandardEntity {
    private static final long serialVersionUID = 5929576816211488307L;

    @Column(name = "FACILITY_CODE", nullable = false, length = 20)
    protected String facilityCode;

    @Column(name = "FACILITY_NAME", nullable = false)
    protected String facilityName;

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityName() {
        return facilityName;
    }


}