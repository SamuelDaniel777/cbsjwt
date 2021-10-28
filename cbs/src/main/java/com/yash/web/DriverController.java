package com.yash.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.domain.Driver;
import com.yash.exception.InvalidData;
import com.yash.serviceimpl.DriverServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	DriverServiceImpl driverServiceImpl;
	
	@PostMapping("/login")
	public Driver driverLogin(Driver driver,HttpSession session) throws InvalidData {
		Driver fromDriver = driverServiceImpl.requestLogin(driver.getEmail(),driver.getPassword());
		if (fromDriver!=null) {
			session.setAttribute("driverSession", fromDriver);
			return fromDriver;
		} else {
			return new Driver();
		}
		
	}
	
	
	@GetMapping("/listDriver")
	public List<Driver> getAllDriver()
	{
		return driverServiceImpl.listDriver();
	}


	@PostMapping("/insertDriver")
	public String insertDriver(@RequestBody Driver driver)
	{
		driverServiceImpl.registerAndUpdateDriver(driver);
		return "Your record is saved successfully";
	}

	@DeleteMapping("/delete/{id}")//http://localhost:8080/cbs/delete/{id}
	public ResponseEntity<HttpStatus> deleteDriverdetail(@PathVariable("id") int id)
	{
		driverServiceImpl.deleteDriver(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
	}

	@PutMapping("/updateDriver")
	public String updateDriver(@RequestBody Driver driver)
	{
		driverServiceImpl.registerAndUpdateDriver(driver);
		return "Your record is saved successfully";
	}


	@GetMapping("/viewDriver/{driverId}")
	public Driver viewDriver(@PathVariable("driverId") int id)
	{
		return driverServiceImpl.getDriverById(id);
	}
	
	@GetMapping("/bestDrivers")
	public List<Driver> getBestDrivers()
	{
		List<Driver> drlist = driverServiceImpl.getBestDrivers();
		return drlist;
	}

}
