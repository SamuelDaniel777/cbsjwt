package com.yash.repository;

/*
 * customer Repository
 * author akshay.patil  
 * 
 */
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.yash.domain.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> 
{
	
	Optional<Customer> findById(int id);

	public Customer findCustomerByName(String name);

	public Customer findByemail(String email);

	@Query("from Customer where email=:em and password=:pd")
	Customer getByNameAndPassowrd(@Param("em")String email,@Param("pd") String password);
	
}