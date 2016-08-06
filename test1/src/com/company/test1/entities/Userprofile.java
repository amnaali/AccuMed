package com.company.test1.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.company.test1.dal.UserprofileDAO;
import com.xdev.dal.DAO;
import com.xdev.util.Caption;

/**
 * Userprofile
 */
@DAO(daoClass = UserprofileDAO.class)
@Caption("{%firstName}")
@Entity
@Table(name = "userprofile", catalog = "accumed")
public class Userprofile implements java.io.Serializable {

	private int userId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String phoneNumber;
	private Date lastLogin;
	private boolean active;

	public Userprofile() {
	}

	public Userprofile(int userId, String firstName, String lastName, Date dateOfBirth, String phoneNumber,
			Date lastLogin, boolean active) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.lastLogin = lastLogin;
		this.active = active;
	}

	@Caption("UserId")
	@Id

	@Column(name = "UserID", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Caption("FirstName")
	@Column(name = "FirstName", nullable = false)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Caption("LastName")
	@Column(name = "LastName", nullable = false)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Caption("DateOfBirth")
	@Temporal(TemporalType.DATE)
	@Column(name = "DateOfBirth", nullable = false, length = 10)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Caption("PhoneNumber")
	@Column(name = "PhoneNumber", nullable = false, length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Caption("LastLogin")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastLogin", nullable = false, length = 19)
	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Caption("Active")
	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
