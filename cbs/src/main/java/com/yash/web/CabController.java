package com.yash.web;

import java.util.Set;
import java.util.logging.Logger;

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

import com.yash.domain.Cab;
import com.yash.repository.CabRepository;
import com.yash.serviceimpl.CabServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cab")
public class CabController {

	Logger logger=Logger.getAnonymousLogger();

	@Autowired
	CabRepository cabRepository;

	@Autowired
	CabServiceImpl cabServiceImpl;

	/**
	 * Insert data in cab
	 * @param cab
	 * @return
	 */
	@PostMapping("/save")//http://localhost:8080/cbs/save
	public ResponseEntity<Object> createcab(@RequestBody Cab cab)
	{
		cabServiceImpl.insertcab(cab);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}


	@DeleteMapping("/delete/{id}")//http://localhost:8080/cbs/delete/{id}
	public ResponseEntity<HttpStatus> deletecab(@PathVariable("id") int id)
	{ 
		try {
			cabServiceImpl.deleteCabdetail(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/update")//http://localhost:8080/cbs/update/{id}
	public ResponseEntity<Object> updatecab(@RequestBody Cab cab) {
		cabServiceImpl.insertcab(cab);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}



	@GetMapping("/typescab/{carType}")//http://localhost:8080/cbs/typescab/{carType}
	public ResponseEntity<Set<Cab>> getAllbycab(@RequestBody Cab cab )
	{
		try {
			Set<Cab> cablistType = cabServiceImpl.viewcabsOfTypes(cab.getCarType());
			if (cablistType.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(cablistType, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	

	@GetMapping("/typescabcount/{carType}")//http://localhost:8080/cbs/typescabcount/{carType}
	public int getAllCabSize(@PathVariable("carType") String carType )
	{
		return cabServiceImpl.countCabsOfType(carType);

	}




}
