package com.company.accumed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s|lastName,firstName")
@Table(name = "ACCUMED_PROVIDER")
@Entity(name = "accumed$Provider")
public class Provider extends StandardEntity {
    private static final long serialVersionUID = -7988232986164874589L;

    @Column(name = "PROVIDER_ID", length = 20)
    protected String providerId;

    @Column(name = "TITLE", length = 20)
    protected String title;

    @Column(name = "FIRST_NAME", nullable = false, length = 100)
    protected String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 100)
    protected String lastName;

    @Column(name = "MIDDLE_NAME", length = 100)
    protected String middleName;

    @Column(name = "EMAIL")
    protected String email;

    @Column(name = "ADDRESS_LINE1", length = 100)
    protected String addressLine1;

    @Column(name = "ADDRESS_LINE2", length = 100)
    protected String addressLine2;

    @Column(name = "CITY", length = 100)
    protected String city;

    @Column(name = "PROVINCE", length = 100)
    protected String province;

    @Column(name = "COUNTRY", length = 20)
    protected String country;

    @Column(name = "POSTAL_CODE", length = 20)
    protected String postalCode;

    @Column(name = "WORK_PHONE", length = 20)
    protected String workPhone;

    @Column(name = "CELL_PHONE", length = 20)
    protected String cellPhone;

    @Column(name = "GROUP_NUMBER")
    protected Integer groupNumber;

    @ManyToOne
    @JoinColumn(name = "PRIMARY_SPECIALTY_ID")
    protected Speciality primarySpecialty;

    @ManyToOne
    @JoinColumn(name = "MINISTRY_OF_HEALTH_OFFICE_ID")
    protected MinistryOfHealthOffice ministryOfHealthOffice;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }


    public void setMinistryOfHealthOffice(MinistryOfHealthOffice ministryOfHealthOffice) {
        this.ministryOfHealthOffice = ministryOfHealthOffice;
    }

    public MinistryOfHealthOffice getMinistryOfHealthOffice() {
        return ministryOfHealthOffice;
    }


    public Speciality getPrimarySpecialty() {
        return primarySpecialty;
    }

    public void setPrimarySpecialty(Speciality primarySpecialty) {
        this.primarySpecialty = primarySpecialty;
    }


    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderId() {
        return providerId;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine2() {
        return addressLine2;
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

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }


}