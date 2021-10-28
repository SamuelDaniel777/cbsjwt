
package com.yash.serviceimpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.domain.Customer;
import com.yash.domain.Driver;
import com.yash.domain.TripBooking;
import com.yash.repository.TripBookingRepository;

@Service
public class TripBookingServiceImpl {
	
	@Autowired
	TripBookingRepository tbrepo;

	Logger logger = LoggerFactory.getLogger(TripBookingServiceImpl.class);

	public TripBooking registerOrUpdateCustomerBooking(TripBooking tb, Customer customer) {
		try {
			logger.trace("method called tripbooking data" + tb);
			tb.setCustomer(customer);
			tbrepo.save(tb);
			TripBooking tripbook = tbrepo.getById(tb.getTripBookingId());
			return tripbook;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean deleteTripById(TripBooking tb) {
		try {
			tbrepo.deleteById(tb.getTripBookingId());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<TripBooking> viewAllTripsById(Customer customer) {
		try {
			List<TripBooking> tblist = tbrepo.getTripsByCustomerId(customer);
			logger.trace("returning null or list reference of type tripbooking" + tblist);
			return tblist;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	public List<TripBooking> getAllTrips() {
		List<TripBooking>tList=tbrepo.getAllTripBookingData();
		return tList;
	}

	
	public Boolean setDriverDetails(TripBooking tb, Driver sDriver) {
		try {
			TripBooking tBooking= tbrepo.getById(tb.getTripBookingId());
			tBooking.setDriver(sDriver);
			tbrepo.save(tBooking);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<TripBooking> getTripsCabWise()
	{
		List<TripBooking> tList = tbrepo.getAllTripBookingData();
		Collections.sort(tList, new Comparator<TripBooking>() {
				@Override
				public int compare(TripBooking tb1, TripBooking tb2) {
					return tb1.getDriver().getCab().getCarType().compareTo(tb2.getDriver().getCab().getCarType());
				}
	        });
		return tList;
	}
	
	public List<TripBooking> getAllTripsForDays(int customerId, Date fromDate, Date toDate)
	{
		//long noOfDays = ChronoUnit.DAYS.between(fromDate, toDate);
		List<TripBooking>tList=tbrepo.getAllTripBookingData();
		List<TripBooking> newList = new ArrayList<TripBooking>();
		for(TripBooking tb : tList)
		{
			if(tb.getCustomer().getCustomerid()==customerId)
			{
				if(tb.getFromDateTime()==fromDate && tb.getToDateTime()==toDate)
				{
					newList.add(tb);			
				}
			}
		}
		return newList;
	}
	
	public List<TripBooking> getTripsDateWise()
	{
		List<TripBooking> tList = tbrepo.getAllTripBookingData();
		Collections.sort(tList, new Comparator<TripBooking>() {
				@Override
				public int compare(TripBooking tb1, TripBooking tb2) {
					return tb1.getFromDateTime().compareTo(tb2.getFromDateTime());
				}
	        });
		return tList;
	}
	
}
