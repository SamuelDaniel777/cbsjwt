package com.yash.service;

/*
 * Customer Service Methods
 * author akshay.patil
 * 
 */

import javax.naming.InvalidNameException;
import com.yash.domain.Customer;
import com.yash.exception.CustomerIdNotFoundException;
import com.yash.exception.RecordNotFoundException;


public interface CustomerService 
{

	
	/*
	 * this getid method is used for getting records by id from table customer
	 */
	public Customer getCustomerById(int custid) throws CustomerIdNotFoundException;

	/*
	 * this getname method is used for getting records by Name from table customer
	 */
	public Customer getCustomerByName(String name) throws InvalidNameException;
	/*
	 * this getemail method is used for getting records by Name from table customer
	 */
	public Customer getCustomerByEmail(String email) throws  RecordNotFoundException;

}
