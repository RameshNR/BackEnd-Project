package com.ecomm.config;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.model.Category;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm.config")
public class DBConfig 
{
	@Bean (name="DataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/priya");
		dataSource.setUsername("priya");
		dataSource.setPassword("priya");
		
		System.out.println("*******DataSource object category**********");
		return dataSource;
	}
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{	
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto","update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(null);
		factory.addProperties((Properties) hibernateProp);
		factory.addAnnotatedClass(Category.class);
		SessionFactory sessionfactory=factory.buildSessionFactory();
		System.out.println("***************sessionfactory******");
		return sessionfactory;
	}
	@Bean("txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("**********Hibernate Transaction0 manager****");
		
		return new HibernateTransactionManager(sessionFactory);
	}
	
}

	