package com.company.test1.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.company.test1.dal.UserloginDAO;
import com.xdev.dal.DAO;
import com.xdev.security.authentication.CredentialsUsernamePassword;
import com.xdev.util.Caption;

/**
 * Userlogin
 */
@DAO(daoClass = UserloginDAO.class)
@Caption("{%username}")
@Entity
@Table(name = "userlogin", catalog = "accumed")
public class Userlogin implements java.io.Serializable, CredentialsUsernamePassword {

	private int id;
	private String username;
	private byte[] password;

	public Userlogin() {
	}

	public Userlogin(String username, byte[] password) {
		this.username = username;
		this.password = password;
	}

	@Caption("Id")
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Caption("Username")
	@Column(name = "username", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Caption("Password")
	@Column(name = "password", nullable = false)
	public byte[] getPassword() {
		return this.password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	@Override
	public String username() {
		return this.getUsername();
	}

	@Override
	public byte[] password() {
		return this.getPassword();
	}

}
