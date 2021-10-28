package com.yash.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.yash.domain.TripBooking;

public interface AdminService 
{
	public List<TripBooking> getAllTrips();
	public List<TripBooking> getTripsCabWise();
	public List<TripBooking> getTripsCustomerWise(int customerId);
	public List<TripBooking> getTripsDateWise();
	public List<TripBooking> getAllTripsForDays(int customerId, Date fromDate, Date toDate);
}
 

