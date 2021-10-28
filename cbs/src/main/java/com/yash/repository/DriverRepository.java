package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.domain.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

	@Query("from Driver where email=:em and password=:pd")
	Driver getByNameAndPassowrd(@Param("em")String email,@Param("pd") String password);
	
}
