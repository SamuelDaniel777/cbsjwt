package com.yash;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		for (int i = 1; i < 10; i++) {
			String encodedString= encoder.encode("password@1234");
			System.out.println(encodedString);
		}
		
	}

}
