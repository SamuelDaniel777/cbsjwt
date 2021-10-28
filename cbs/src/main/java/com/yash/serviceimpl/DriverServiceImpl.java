package com.yash.serviceimpl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.domain.Driver;
import com.yash.exception.InvalidData;
import com.yash.repository.DriverRepository;

@Service
public class DriverServiceImpl {

	@Autowired
	DriverRepository driverRepository;
		
	public Driver requestLogin(String email, String password) throws InvalidData {

		try {
			Driver driver= driverRepository.getByNameAndPassowrd(email, password);
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Read
	public List<Driver> listDriver()
	{
		return (List<Driver>) driverRepository.findAll();
	}

	//Create
	public boolean registerAndUpdateDriver(Driver driver)
	{
		try 
		{
			driverRepository.save(driver);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	//Delete
	public Driver deleteDriver(int id)
	{
		try {
			driverRepository.deleteById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	// get driver by id
	public Driver getDriverById(int id)
	{
		try
		{
			Driver dri = driverRepository.findById(id).get();
			return dri;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	// get drivers whose rating>4.0
	
	public List<Driver> getBestDrivers()
	{
		try
		{
			List<Driver> list = new ArrayList<Driver>();
			List<Driver> dlist = driverRepository.findAll();
			for(Driver dri : dlist)
			{
				float rating = dri.getRating();
				if(rating>4.0)
				{
					list.add(dri);
				}
			}
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
