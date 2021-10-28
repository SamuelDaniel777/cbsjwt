
package com.yash.domain;

import java.sql.Date;
/*
* POJO TripBooking class
* containing instance variables, constructors
* getters setters and toString() method
*
* author:- @Daniel
*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "trip_booking")
public class TripBooking {

	/* id stores the value of trip booking id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trip_Booking_id")
	private int tripBookingId;
	/*
	 * customer stores the value of customer entity - one to one mapped with trip
	 * booking-
	 */
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	/*
	 * driver stores the value of driver entity - many to one mapped with trip
	 * booking
	 */
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;
	/*
	 * fromLocation stores the value of location from where customer has booked the
	 * cab
	 */

	@Column(name = "fromLocation")
	private String fromLocation;
	/*
	 * toLocation stores the value of location till where customer has booked the
	 * cab
	 */

	@Column(name = "toLocation")
	private String toLocation;
	/*
	 * fromDateTime stores the value of date and time on which the customer has
	 * booked the cab
	 */
	//@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name = "fromDateTime")
	private Date fromDateTime;
	/*
	 * toDateTime stores the value of date and time on which the customer has left
	 * the cab
	 */
	//@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name = "toDateTime")
	private Date toDateTime;

	/* status stores the value of status of the trip */
	@Column(name = "status")
	private boolean status;

	/* distance stores the value of total distance covered by the cab in kms */
	@Column(name = "distanceInKm")
	private float distanceInKm;

	/* bill stores the value of total amount paid by the customer for a trip */
	@Column(name = "bill")
	private float bill;

	/* default constructor */
	public TripBooking() {
	} /* parametrized constructor for initializing values to instance variables */

	/**
	 * @return the tripBookingId
	 */
	public int getTripBookingId() {
		return tripBookingId;
	}

	/**
	 * @param tripBookingId the tripBookingId to set
	 */
	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the driver
	 */
	public Driver getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	/**
	 * @return the fromLocation
	 */
	public String getFromLocation() {
		return fromLocation;
	}

	/**
	 * @param fromLocation the fromLocation to set
	 */
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	/**
	 * @return the toLocation
	 */
	public String getToLocation() {
		return toLocation;
	}

	/**
	 * @param toLocation the toLocation to set
	 */
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	/**
	 * @return the fromDateTime
	 */
	public Date getFromDateTime() {
		return fromDateTime;
	}

	/**
	 * @param fromDateTime the fromDateTime to set
	 */
	public void setFromDateTime(Date fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	/**
	 * @return the toDateTime
	 */
	public Date getToDateTime() {
		return toDateTime;
	}

	/**
	 * @param toDateTime the toDateTime to set
	 */
	public void setToDateTime(Date toDateTime) {
		this.toDateTime = toDateTime;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the distanceInKm
	 */
	public float getDistanceInKm() {
		return distanceInKm;
	}

	/**
	 * @param distanceInKm the distanceInKm to set
	 */
	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	/**
	 * @return the bill
	 */
	public float getBill() {
		return bill;
	}

	/**
	 * @param bill the bill to set
	 */
	public void setBill(float bill) {
		this.bill = bill;
	}

	/* toString() to print the object of tripbooking */
	@Override
	public String toString() {
		return "TripBooking [tripBookingId=" + tripBookingId + ", customer=" + customer + ", driver=" + driver
				+ ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", fromDateTime=" + fromDateTime
				+ ", toDateTime=" + toDateTime + ", status=" + status + ", distanceInKm=" + distanceInKm + ", bill="
				+ bill + "]";
	}
	
	
}
