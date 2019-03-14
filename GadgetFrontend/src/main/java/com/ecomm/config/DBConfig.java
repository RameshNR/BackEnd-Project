package com.ecomm.config;

import java.util.Properties;
import javax.activation.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm.config")
public class DBConfig {
	
	@Bean(name="DataSource")
	public DataSource getH2DataSource() 
	{
		
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/NR");
		dataSource.setUsername("ram");
		dataSource.setPassword("ram");
	
		System.out.println("== DataSource Object created ==");
		return (DataSource) dataSource;     /// Don't use the type cast 
		
	}
	
	@Bean (name="SessionFactory")
	public SessionFactory getSessionFactory() 
	{
		
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto",  "update");
		hibernateProp.put("hibernate.dialect",  "org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(null);
		factory.addProperties((Properties) hibernateProp);
		SessionFactory sessionfactory=factory.buildSessionFactory();
		return sessionfactory;
		
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) 
	{
		System.out.println("********** Hibernate Transaction Manager ***********");
		return new HibernateTransactionManager(sessionFactory);
	}
	

}
