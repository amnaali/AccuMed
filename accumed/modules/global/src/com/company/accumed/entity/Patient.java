package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.global.DesignSupport;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.core.entity.Versioned;
import com.haulmont.cuba.core.entity.SoftDelete;
import com.haulmont.cuba.core.entity.Updatable;

@DesignSupport("{'imported':true}")
@Table(name = "ACCUMED_PATIENT")
@Entity(name = "accumed$Patient")
public class Patient extends BaseUuidEntity implements Versioned, SoftDelete, Updatable {
    private static final long serialVersionUID = 2320433814456084023L;

    @Column(name = "patientid")
    protected Double patientid;

    @Column(name = "healthnum")
    protected String healthnum;

    @Column(name = "versioncode")
    protected String versioncode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expyear")
    protected Date expyear;

    @Column(name = "fname")
    protected String fname;

    @Column(name = "lname")
    protected String lname;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dob")
    protected Date dob;

    @Column(name = "sex", length = 10)
    protected String sex;

    @Column(name = "address", length = 2000)
    protected String address;

    @Column(name = "city")
    protected String city;

    @Column(name = "province")
    protected String province;

    @Column(name = "postalcode")
    protected String postalcode;

    @Column(name = "country")
    protected String country;

    @Column(name = "hphone")
    protected String hphone;

    @Column(name = "wphone")
    protected String wphone;

    @Column(name = "refdoc", length = 1000)
    protected String refdoc;

    @Column(name = "famdoc", length = 1000)
    protected String famdoc;

    @Column(name = "facilitynum")
    protected String facilitynum;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "admitdate")
    protected Date admitdate;

    @Lob
    @Column(name = "notes")
    protected String notes;

    @Lob
    @Column(name = "batchid")
    protected String batchid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hncheckdate")
    protected Date hncheckdate;

    @Column(name = "status")
    protected Double status;

    @Lob
    @Column(name = "response")
    protected String response;

    @Lob
    @Column(name = "hl7patid")
    protected String hl7patid;

    @Column(name = "flag", length = 1)
    protected String flag;

    @Column(name = "DELETE_TS")
    protected Date deleteTs;

    @Column(name = "DELETED_BY", length = 50)
    protected String deletedBy;

    @Column(name = "UPDATE_TS")
    protected Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    protected String updatedBy;

    @Version
    @Column(name = "VERSION")
    protected Integer version;

    @Override
    public Boolean isDeleted() {
        return deleteTs != null;
    }


    public void setPatientid(Double patientid) {
        this.patientid = patientid;
    }

    public Double getPatientid() {
        return patientid;
    }

    public void setHealthnum(String healthnum) {
        this.healthnum = healthnum;
    }

    public String getHealthnum() {
        return healthnum;
    }

    public void setVersioncode(String versioncode) {
        this.versioncode = versioncode;
    }

    public String getVersioncode() {
        return versioncode;
    }

    public void setExpyear(Date expyear) {
        this.expyear = expyear;
    }

    public Date getExpyear() {
        return expyear;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    public String getHphone() {
        return hphone;
    }

    public void setWphone(String wphone) {
        this.wphone = wphone;
    }

    public String getWphone() {
        return wphone;
    }

    public void setRefdoc(String refdoc) {
        this.refdoc = refdoc;
    }

    public String getRefdoc() {
        return refdoc;
    }

    public void setFamdoc(String famdoc) {
        this.famdoc = famdoc;
    }

    public String getFamdoc() {
        return famdoc;
    }

    public void setFacilitynum(String facilitynum) {
        this.facilitynum = facilitynum;
    }

    public String getFacilitynum() {
        return facilitynum;
    }

    public void setAdmitdate(Date admitdate) {
        this.admitdate = admitdate;
    }

    public Date getAdmitdate() {
        return admitdate;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    public String getBatchid() {
        return batchid;
    }

    public void setHncheckdate(Date hncheckdate) {
        this.hncheckdate = hncheckdate;
    }

    public Date getHncheckdate() {
        return hncheckdate;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    public Double getStatus() {
        return status;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setHl7patid(String hl7patid) {
        this.hl7patid = hl7patid;
    }

    public String getHl7patid() {
        return hl7patid;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    @Override
    public void setDeleteTs(Date deleteTs) {
        this.deleteTs = deleteTs;
    }

    @Override
    public Date getDeleteTs() {
        return deleteTs;
    }

    @Override
    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    public String getDeletedBy() {
        return deletedBy;
    }

    @Override
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    @Override
    public Date getUpdateTs() {
        return updateTs;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public Integer getVersion() {
        return version;
    }


}