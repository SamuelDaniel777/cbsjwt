package com.yash.serviceimpl;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.domain.Admin;
import com.yash.domain.Customer;
import com.yash.domain.TripBooking;
import com.yash.exception.InvalidData;
import com.yash.repository.AdminRepository;
import com.yash.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService
{

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	TripBookingServiceImpl tripbookingimpl;

	Logger logger=LoggerFactory.getLogger(AdminServiceImpl.class);

	//Admin Login Service Logic
	public Admin requestLogin(String email, String password) throws InvalidData {

		try {
			
			logger.trace("admin data recieved at AdminServiceImpl"+email+password);
			Admin admin = adminRepository.getByNameAndPassowrd(email, password);
			logger.trace("admin details"+admin);
			return admin;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidData("Data Does not exist");
		}
		
	}
	
	//insert or update admin
	
	public Admin saveOrUpdate(Admin admin)
	{
		try
		{
			Admin adminData = adminRepository.save(admin);
			logger.trace("Admin data: "+adminData);
			return adminData;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	// get list of admin
	
	public List<Admin> getAdmin()
	{
		try 
		{
			List<Admin> list = adminRepository.findAll();
			return list;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	//delete admin
	
	public void deleteAdmin(int id)
	{
		try 
		{
			adminRepository.deleteById(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	//get trips customer wise on the basis of customer id
	
	@Override
	public List<TripBooking> getTripsCustomerWise(int customerId) 
	{	
		try
		{
			//Customer customer = new Customer();
			//customer.setCustomerid(customerId);
			
			TripBooking tb1 = new TripBooking();
			tb1.getCustomer().setCustomerid(customerId);
			List<TripBooking> tb = tripbookingimpl.viewAllTripsById(tb1.getCustomer());
			return tb;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}

	// get trips date wise
	
	@Override
	public List<TripBooking> getTripsDateWise()
	{
		List<TripBooking> tlist = tripbookingimpl.getTripsDateWise();
		return tlist;
	}

	// get all trips
	
	@Override
	public List<TripBooking> getAllTrips()
	{
		try 
		{
			List<TripBooking> list = tripbookingimpl.getAllTrips();
			return list;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	//get all trips for days mentioned
	
	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, Date fromDate, Date toDate) 
	{

		List<TripBooking> tlist = tripbookingimpl.getAllTripsForDays(customerId, fromDate, toDate);
		return tlist;
		
	}

	//get trips cab wise
	
	@Override
	public List<TripBooking> getTripsCabWise() {
		
		List<TripBooking> tlist = tripbookingimpl.getTripsCabWise();
		return tlist;
	}
	
	
	
}
