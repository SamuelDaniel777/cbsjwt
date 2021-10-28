package com.yash.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * cab class
 * @author abhishek.maurya
 *
 */

@Entity
@Table(name="cab_data")
public class Cab {

	/**
	 * id of cabid
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cabid;

	/**
	 * carType for cab
	 */
	@NotBlank(message = "cartype is required")
	private String carType;
	
	/**
	 * cab rate per kilometer
	 */
	@NotBlank(message = "perkmrate is required")
	private float perkmRate;
		
	/**
	 * blank 
	 */
	public Cab() {
		super();
	}

	/**
	 * @param cabid
	 * @param carType
	 * @param perkmRate
	 */
	public Cab(int cabid, @NotBlank(message = "cartype is required") String carType,
			@NotBlank(message = "perkmrate is required") float perkmRate) {
		super();
		this.cabid = cabid;
		this.carType = carType;
		this.perkmRate = perkmRate;
	}

	/**
	 * @return the cabid
	 */
	public int getCabid() {
		return cabid;
	}

	/**
	 * @param cabid the cabid to set
	 */
	public void setCabid(int cabid) {
		this.cabid = cabid;
	}

	/**
	 * @return the carType
	 */
	public String getCarType() {
		return carType;
	}

	/**
	 * @param carType the carType to set
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	/**
	 * @return the perkmRate
	 */
	public float getPerkmRate() {
		return perkmRate;
	}

	/**
	 * @param perkmRate the perkmRate to set
	 */
	public void setPerkmRate(float perkmRate) {
		this.perkmRate = perkmRate;
	}

	@Override
	public String toString() {
		return "Cab [cabid=" + cabid + ", carType=" + carType + ", perkmRate=" + perkmRate + "]";
	}

}
