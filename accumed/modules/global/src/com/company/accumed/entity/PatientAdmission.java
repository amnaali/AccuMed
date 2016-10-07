package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s - %s|patient,facility")
@Table(name = "ACCUMED_PATIENT_ADMISSION")
@Entity(name = "accumed$PatientAdmission")
public class PatientAdmission extends StandardEntity implements Comparable<PatientAdmission> {
    private static final long serialVersionUID = 6583659411541910193L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FACILITY_ID")
    protected Facility facility;

    @Temporal(TemporalType.DATE)
    @Column(name = "ADMIT_DATE", nullable = false)
    protected Date admitDate;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    protected Patient patient;


    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Facility getFacility() {
        return facility;
    }


    public void setAdmitDate(Date admitDate) {
        this.admitDate = admitDate;
    }

    public Date getAdmitDate() {
        return admitDate;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public int compareTo(PatientAdmission o) {
        if (this.createTs == null) {
            return -1;
        }
        return (o.createTs == null) ? Integer.MAX_VALUE : (o.createTs.compareTo(this.createTs));
    }
}

