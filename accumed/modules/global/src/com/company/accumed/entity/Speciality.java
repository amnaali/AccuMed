package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|specialtyName")
@Table(name = "ACCUMED_SPECIALITY")
@Entity(name = "accumed$Speciality")
public class Speciality extends StandardEntity {
    private static final long serialVersionUID = -6154891131392217419L;

    @Column(name = "SPECIALTY_CODE", nullable = false, unique = true, length = 6)
    protected String specialtyCode;

    @Column(name = "SPECIALTY_NAME", nullable = false)
    protected String specialtyName;

    public void setSpecialtyCode(String specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

    public String getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }


}