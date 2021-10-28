package com.yash.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yash.domain.Customer;
import com.yash.domain.Driver;
import com.yash.domain.TripBooking;
import com.yash.serviceimpl.TripBookingServiceImpl;

/**
 * controller for project class mapping the URL from here
 * 
 * @author daniel
 *
 */

@RestController
@RequestMapping("/tripbooking")
@CrossOrigin(origins = "http://localhost:3000")
public class TripBookingController {

	@Autowired
	TripBookingServiceImpl tripbookingimpl;

	Logger logger = LoggerFactory.getLogger(TripBookingController.class);

	@PostMapping("/registerbycustomer")
	public TripBooking getTripBooking(TripBooking tb, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		logger.trace("customer data recieved" + customer + tb);
		TripBooking tripBooking = tripbookingimpl.registerOrUpdateCustomerBooking(tb, customer);
		logger.trace("done" + tripBooking);
		return tripBooking;

	}

	@PostMapping("/updatetripbooking")
	public TripBooking updateTripBooking(TripBooking tb) {
		logger.trace("data recieved" + tb);
		Customer customer = null;
		TripBooking tripBooking = tripbookingimpl.registerOrUpdateCustomerBooking(tb, customer);
		return tripBooking;

	}

	@PostMapping("/deletetrip")
	public Boolean deleteTripBooking(TripBooking tb) {
		logger.trace("data recieved" + tb);
		Boolean b = tripbookingimpl.deleteTripById(tb);
		return b;

	}

	@GetMapping("/viewtrips")
	public List<TripBooking> viewTripBookings(HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		logger.trace("got customer id" + customer.getCustomerid());
		List<TripBooking> list = tripbookingimpl.viewAllTripsById(customer);
		return list;
		
	}

	@GetMapping("/viewalltrips")
	public List<TripBooking> getAllTripBookings() {
		List<TripBooking> tList=tripbookingimpl.getAllTrips();
		return tList;
		
	}
	
	@PostMapping("/confirmdriver")
	public Boolean driverConfirm(TripBooking tb,HttpSession session) {
		Driver sDriver= (Driver)session.getAttribute("driverSession");
		logger.trace("driver data recieved"+sDriver);
		Boolean b=tripbookingimpl.setDriverDetails(tb,sDriver);
		logger.trace("status value"+b);
		return b;
	}
	

}
