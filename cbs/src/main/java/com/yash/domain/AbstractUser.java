package com.yash.domain;

/*
Abstract User Class For Common Fields 
*Author:-@Daniel
*/

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractUser {
	
	//Field user name(Mandatory Field)
	@Column(nullable = false)
	protected String name;
	
	//Field User Passowrd(Mandatory Field)
	@Column(nullable = false)
	protected String password;
	
	//Field User Address(Mandatory Field)
	@Column(nullable = false)
	protected String address;
	
	//Field User MobileNumber(Mandatory Field, Unique Field)
	@Column(nullable = false, unique = true)
	protected String mobileNumber;
	
	//Field User email(Mandatory Field, Unique Field)
	@Column(nullable = false, unique = true)
	protected String email;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
