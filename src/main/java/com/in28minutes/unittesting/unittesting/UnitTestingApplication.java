package com.in28minutes.unittesting.unittesting;

//import java.util.Arrays;
//import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UnitTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingApplication.class, args);
		//ApplicationContext ctx = SpringApplication.run(UnitTestingApplication.class, args);
		
		
//		List<Integer> values = Arrays.asList(1,2,3,4,5);
		
		//External loop
//		for (int i = 0 ; i < values.size(); i++) {
//			System.out.println(values.get(i));
//		} 
		
		//External loop   -- Enhanced Loop
//		for (int i : values) {
//			System.out.println(i);
//		}
		
		//Internal loop -- faster -- 
//		values.forEach(i -> System.out.println(i));
		
	}

}
