package com.Jeyasco.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyprojectApplication 
{

	public static void main(String[] args) 
	{
		ApplicationContext context=SpringApplication.run(MyprojectApplication.class, args);
		
		Dev obj=context.getBean(Dev.class);
		obj.build();
		
		
	}

}
