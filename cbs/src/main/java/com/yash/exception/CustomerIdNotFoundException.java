package com.yash.exception;


/**
 * handle Exception by user define;
 * if Employee ID not found then this exception accured;
 * @author akshay.patil
 *
 */

public class CustomerIdNotFoundException extends Exception
{

	public CustomerIdNotFoundException(String msg) 
	{
		super(msg);
	}

}
