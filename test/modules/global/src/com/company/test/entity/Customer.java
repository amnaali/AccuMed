package com.company.test.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;

@NamePattern("%s|name")
@Table(name = "TEST_CUSTOMER")
@Entity(name = "test$Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -5207085727934395399L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "EMAIL", nullable = false)
    protected String email;


    @Lob
    @Column(name = "DATES")
    protected String dates;

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getDates() {
        return dates;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


}