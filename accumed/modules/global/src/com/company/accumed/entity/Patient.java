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
<<<<<<< HEAD
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.OneToMany;

@NamePattern("%s %s|firstName,lastName")
=======

>>>>>>> 802bc6e5bed0cad934e8937b5e727eb925303994
@DesignSupport("{'imported':true}")
@Table(name = "ACCUMED_PATIENT")
@Entity(name = "accumed$Patient")
public class Patient extends BaseUuidEntity implements Versioned, SoftDelete, Updatable {
    private static final long serialVersionUID = 2320433814456084023L;

<<<<<<< HEAD
    @Column(name = "MEMBER_NUMBER", length = 20)
    protected String memberNumber;

    @Column(name = "VERSION_CODE", length = 12)
    protected String versionCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXPIRED_ON")
    protected Date expiredOn;

    @Column(name = "FIRST_NAME", length = 100)
    protected String firstName;

    @Column(name = "MIDDLE_NAME", length = 100)
    protected String middleName;

    @Column(name = "LAST_NAME", length = 100)
    protected String lastName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BIRTH_DATE")
    protected Date birthDate;

    @Column(name = "GENDER")
    protected String gender;

    @Column(name = "EMAIL")
    protected String email;

    @Column(name = "ADDRESS_LINE1")
    protected String addressLine1;

    @Column(name = "ADDRESS_LINE2")
    protected String addressLine2;

    @Column(name = "city", length = 100)
    protected String city;

    @Column(name = "province", length = 100)
    protected String province;

    @Column(name = "POSTAL_CODE", length = 20)
    protected String postalCode;

    @Column(name = "country", length = 20)
    protected String country;

    @Column(name = "HOME_PHONE", length = 20)
    protected String homePhone;

    @Column(name = "WORK_PHONE", length = 20)
    protected String workPhone;

    @Column(name = "CELL_PHONE", length = 20)
    protected String cellPhone;

    @Column(name = "REFERRING_DOCTOR")
    protected String referringDoctor;

    @Column(name = "FAMILY_DOCTOR")
    protected String familyDoctor;

    @Column(name = "FACILITY_CODE")
    protected String facilityCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ADMIT_DATE")
    protected Date admitDate;
=======
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
>>>>>>> 802bc6e5bed0cad934e8937b5e727eb925303994

    @Lob
    @Column(name = "notes")
    protected String notes;

<<<<<<< HEAD
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HN_CHECK_DATE")
    protected Date hnCheckDate;
=======
    @Lob
    @Column(name = "batchid")
    protected String batchid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hncheckdate")
    protected Date hncheckdate;

    @Column(name = "status")
    protected Double status;
>>>>>>> 802bc6e5bed0cad934e8937b5e727eb925303994

    @Lob
    @Column(name = "response")
    protected String response;

    @Lob
<<<<<<< HEAD
    @Column(name = "HL7_PATIENT_ID")
    protected String hl7PatientId;


    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "patient")
    protected Set<PatientAdmission> admissions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FAM_DOC_ID")
    protected Provider famDoc;

    @Version
    @Column(name = "VERSION", nullable = false)
    protected Integer version;
=======
    @Column(name = "hl7patid")
    protected String hl7patid;

    @Column(name = "flag", length = 1)
    protected String flag;
>>>>>>> 802bc6e5bed0cad934e8937b5e727eb925303994

    @Column(name = "DELETE_TS")
    protected Date deleteTs;

    @Column(name = "DELETED_BY", length = 50)
    protected String deletedBy;

    @Column(name = "UPDATE_TS")
    protected Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    protected String updatedBy;

<<<<<<< HEAD

    public void setFamDoc(Provider famDoc) {
        this.famDoc = famDoc;
    }

    public Provider getFamDoc() {
        return famDoc;
    }


    public void setAdmissions(Set<PatientAdmission> admissions) {
        this.admissions = admissions;
    }

    public Set<PatientAdmission> getAdmissions() {
        return admissions;
    }


    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    public String getFacilityCode() {
        return facilityCode;
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
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    @Override
    public Date getUpdateTs() {
        return updateTs;
    }


    @Override
    public Boolean isDeleted() {
        return deleteTs != null;
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
    public void setDeleteTs(Date deleteTs) {
        this.deleteTs = deleteTs;
    }

    @Override
    public Date getDeleteTs() {
        return deleteTs;
    }


    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public Integer getVersion() {
        return version;
    }


    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine2() {
        return addressLine2;
    }


    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setExpiredOn(Date expiredOn) {
        this.expiredOn = expiredOn;
    }

    public Date getExpiredOn() {
        return expiredOn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender == null ? null : gender.getId();
    }

    public Gender getGender() {
        return gender == null ? null : Gender.fromId(gender);
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setReferringDoctor(String referringDoctor) {
        this.referringDoctor = referringDoctor;
    }

    public String getReferringDoctor() {
        return referringDoctor;
    }

    public void setFamilyDoctor(String familyDoctor) {
        this.familyDoctor = familyDoctor;
    }

    public String getFamilyDoctor() {
        return familyDoctor;
    }

    public void setAdmitDate(Date admitDate) {
        this.admitDate = admitDate;
    }

    public Date getAdmitDate() {
        return admitDate;
    }

    public void setHnCheckDate(Date hnCheckDate) {
        this.hnCheckDate = hnCheckDate;
    }

    public Date getHnCheckDate() {
        return hnCheckDate;
    }

    public void setHl7PatientId(String hl7PatientId) {
        this.hl7PatientId = hl7PatientId;
    }

    public String getHl7PatientId() {
        return hl7PatientId;
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

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
=======
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
>>>>>>> 802bc6e5bed0cad934e8937b5e727eb925303994
    }


}