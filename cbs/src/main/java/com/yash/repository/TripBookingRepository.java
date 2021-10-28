 package com.yash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.domain.Customer;
import com.yash.domain.TripBooking;

/*
* TripBookingRepository inheriting the methods from JpaRepository
* JpaRepository methods: save(), findById(), findAll(), count(), delete(), deleteById()...
*
* @author Samuel
* */

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer>{
	
	@Query("select tb from TripBooking tb where customer=:c")
	List<TripBooking> getTripsByCustomerId(@Param("c")Customer customer);

	@Query("from TripBooking")
	List<TripBooking> getAllTripBookingData();

 }