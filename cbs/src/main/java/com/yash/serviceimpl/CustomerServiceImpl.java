package com.yash.serviceimpl;

/*
 * Customer Service implementation
 * author akshay.patil
 * 
 */
import java.util.List;
import javax.naming.InvalidNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.domain.Customer;
import com.yash.exception.CustomerIdNotFoundException;
import com.yash.exception.InvalidData;
import com.yash.exception.RecordNotFoundException;
import com.yash.repository.CustomerRepository;
import com.yash.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	CustomerRepository customerRepository;
	/*
	 * customer inserted
	 */
	
	public Customer requestLogin(String email, String password) throws InvalidData {

		try {
			Customer customer= customerRepository.getByNameAndPassowrd(email, password);
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	public Customer insertCustomer(Customer customer) 
	{
		try {
			
		
		return customerRepository.save(customer);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return customer;
		
	}

	/*
	 * find list of customer 
	 */
   public List<Customer> listCustomer() 
   {
		return( List<Customer>)customerRepository.findAll();
		
	}
	/*
	 * delete customer
	 */
   public Customer deleteCustomer(int custid) throws CustomerIdNotFoundException 
   {
	   try {
		   
	  
	 customerRepository.deleteById(custid);
	   }
	   catch(Exception e)
	   {
		   throw new CustomerIdNotFoundException("Customer Id Not Found");
	   }
	return null;
	   
   }
	/*
	 * find customer by id
	 */
	@Override
	public Customer getCustomerById(int custid) throws CustomerIdNotFoundException {
		Customer customer = customerRepository.findById(custid).get();
		
		if(customer!=null) 
		{
		return customer;
		} else {
		throw new CustomerIdNotFoundException ("customer ID NOT FOUND");
		}
	}
	/*
	 * find customer by name
	 */
	@Override
	public Customer getCustomerByName(String name) throws InvalidNameException {
		Customer customer = customerRepository.findCustomerByName(name.toUpperCase());
		if(customer==null)
		{
		throw new InvalidNameException("customer name"+ name.toUpperCase());
		}

		return customer;
	}
	/*
	 * get customer by email
	 */
	@Override
	public Customer getCustomerByEmail(String email) throws  RecordNotFoundException 
	{
		Customer customer = customerRepository.findCustomerByName(email.toUpperCase());
		if(customer==null)
		{
		throw new RecordNotFoundException("customer email"+ email.toUpperCase());
		}

		return customer;

	}
}

