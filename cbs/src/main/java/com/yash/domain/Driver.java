package com.yash.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/* Driver POJO */
@Entity
@Table(name = "driver_data")
public class Driver extends AbstractUser
{

	/*
	 * Driver Id 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	
	/*
	 * Driver Licence Number 
	 */
	//@NotBlank(message = "Licence number is required")
	//@Size(min = 4, max = 255, message = "please use 4 to 255 characters for licence Number")
	private String licenceNo;

	@OneToOne
	@JoinColumn(name = "cabid")
	private Cab cab;
	
	
	/*
	 * Driver Rating
	 */
	//@NotBlank(message = "Rating is required")
	private float rating;

	/**
	 * @return the driverId
	 */
	public int getDriverId() {
		return driverId;
	}

	/**
	 * @param driverId the driverId to set
	 */
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	/**
	 * @return the licenceNo
	 */
	public String getLicenceNo() {
		return licenceNo;
	}

	/**
	 * @param licenceNo the licenceNo to set
	 */
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	/**
	 * @return the cab
	 */
	public Cab getCab() {
		return cab;
	}

	/**
	 * @param cab the cab to set
	 */
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	
	/**
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(float rating) {
		this.rating = rating;
	}

	//Default Constructor 
	public Driver() 
	{
		super();
	}

	//ToString Method
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenceNo=" + licenceNo + ", cab=" + cab + ", rating=" + rating
				+ ", name=" + name + ", password=" + password + ", address=" + address + ", mobileNumber="
				+ mobileNumber + ", email=" + email + "]";
	}


}
