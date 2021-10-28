package com.yash.domain;

import javax.persistence.Column;

/*
 *Admin Pojo and data Abstraction from User
 *Author:-@Daniel 
*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_data")
public class Admin extends AbstractUser{

	// Admin Id Declared and Auto Generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminid;

	/**
	 * @return the adminid
	 */
	public int getAdminid() {
		return adminid;
	}
	
	/**
	 * @param adminid the adminid to set
	 */
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", name=" + name + ", password=" + password + ", address=" + address
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", getAdminid()=" + getAdminid()
				+ ", getName()=" + getName() + ", getPassword()=" + getPassword() + ", getAddress()=" + getAddress()
				+ ", getMobileNumber()=" + getMobileNumber() + ", getEmail()=" + getEmail() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
