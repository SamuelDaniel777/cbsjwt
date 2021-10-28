package com.yash.repository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.domain.Cab;
/**
 * 
 * @author abhishek.maurya
 *
 */

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {
	
	@Query(value = "select c from Cab c where c.carType=:ct")
	public Set<Cab> viewcabsOfTypes(@Param("ct") String carType);
	
	@Query(value = "select c from Cab c where c.carType=:ct")
	public Set<Cab> countCabsOfType(@Param("ct") String carType);
	
}
