package com.yash.service;

/*
* Interface having declaration of all the service methods of TripBooking
* it provides standardization to the application
*
* @author usha
*/

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.domain.TripBooking;

@Service
public interface TripBookingService {
	/*
	 * this method is used for fetching records of trips on the basis of customer id
	 */

	public List<TripBooking> getAllTripsByCustomer(int customer_id);

	/*
	 * this method is used for calculating bill of trip on the basis of customer id
	 */
	
	public TripBooking calculateBill(int customer_id);
	
   }