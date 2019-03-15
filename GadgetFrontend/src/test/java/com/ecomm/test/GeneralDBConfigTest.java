package com.ecomm.test;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralDBConfigTest {

	public static void main(String [] args) 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		SessionFactory sessionFactroy = (SessionFactory)context.getBean("sessionFactroy");
	}
}
