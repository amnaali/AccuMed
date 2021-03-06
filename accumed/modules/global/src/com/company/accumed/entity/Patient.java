package com.company.accumed.entity;

import javax.persistence.*;

import com.haulmont.cuba.core.global.DesignSupport;
import java.util.Date;

import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.core.entity.Versioned;
import com.haulmont.cuba.core.entity.SoftDelete;
import com.haulmont.cuba.core.entity.Updatable;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;

@NamePattern("%s %s [%s]|firstName,lastName,memberNumber")
@DesignSupport("{'imported':true}")
@Table(name = "ACCUMED_PATIENT")
@Entity(name = "accumed$Patient")
public class Patient extends BaseUuidEntity implements Versioned, SoftDelete, Updatable {
    private static final long serialVersionUID = 2320433814456084023L;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FAMILY_DOCTOR_ID")
    protected Provider familyDoctor;

    @Lob
    @Column(name = "notes")
    protected String notes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HN_CHECK_DATE")
    protected Date hnCheckDate;

    @Lob
    @Column(name = "response")
    protected String response;

    @Lob
    @Column(name = "HL7_PATIENT_ID")
    protected String hl7PatientId;


    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "patient")
    protected Set<PatientAdmission> admissions;

    @Version
    @Column(name = "VERSION", nullable = false)
    protected Integer version;

    @Column(name = "DELETE_TS")
    protected Date deleteTs;

    @Column(name = "DELETED_BY", length = 50)
    protected String deletedBy;

    @Column(name = "UPDATE_TS")
    protected Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    protected String updatedBy;



    public Provider getFamilyDoctor() {
        return familyDoctor;
    }

    public void setFamilyDoctor(Provider familyDoctor) {
        this.familyDoctor = familyDoctor;
    }




    public void setAdmissions(Set<PatientAdmission> admissions) {
        this.admissions = admissions;
    }

    public Set<PatientAdmission> getAdmissions() {
        return admissions;
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
    }


}