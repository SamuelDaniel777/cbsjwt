package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query("from Admin where email=:em and password=:pd")
	Admin getByNameAndPassowrd(@Param("em")String email,@Param("pd") String password);
	
	
}
