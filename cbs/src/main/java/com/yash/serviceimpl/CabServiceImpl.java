package com.yash.serviceimpl;


import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.domain.Cab;
import com.yash.exception.CabIdException;
import com.yash.repository.CabRepository;


@Service
public class CabServiceImpl
{

	Logger logger= Logger.getAnonymousLogger();

	@Autowired
	CabRepository cabrepository;
	

	public Cab insertcab(Cab cab)
	{
		try {
		return cabrepository.save(cab);	
		}catch(Exception c)
		{
			c.printStackTrace();
		}
		return cab;
	}
	

	public Cab deleteCabdetail(int id)
	{
		try {
		cabrepository.deleteById(id);
		}catch(Exception c)
		{
			throw new CabIdException("ID NOT FOUND");
		}
		return null;
		
	}
	

	
	public Set<Cab> viewcabsOfTypes(String carType) {
		try {
			Set<Cab> cablistCabs= cabrepository.viewcabsOfTypes(carType);
			return cablistCabs;	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public int countCabsOfType(String carType)
	{
		return cabrepository.viewcabsOfTypes(carType).size();
		
	}



}
