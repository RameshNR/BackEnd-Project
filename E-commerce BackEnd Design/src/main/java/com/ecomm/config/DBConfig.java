package com.ecomm.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.ecomm.dao.CategoryDAOImpl;
import com.ecomm.dao.ProductDAOImpl;
import com.ecomm.dao.UserDAOImpl;

import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.UserDetail;

@Configuration
@ComponentScan("com.ecomm")
@EnableTransactionManagement
public class DBConfig {
	
	 @Bean(name="dataSource")
	 public DataSource getH2DataSource()
     {
     	System.out.println("Starting of the method getH2DataSource");
     	DriverManagerDataSource dataSource = new DriverManagerDataSource();
     	dataSource.setDriverClassName("org.h2.Driver");
     	dataSource.setUrl("jdbc:h2:tcp://localhost/~/NR");
     	dataSource.setUsername("ram");
     	dataSource.setPassword("ram");
     	System.out.println("Data source creation");
     	return dataSource;
     }
	 
	 
	 @Autowired
     @Bean(name="sessionFactory")
	 public SessionFactory getSessionFactory(DataSource dataSource)
     {  
     	System.out.println("----  Hibernate Properties Creating  ----");
     	
     	
     	Properties prop = new Properties();
     	prop.setProperty("hibernate.hbm2ddl.auto", "update");
     	prop.put("hibernate.show_sql", "true");
     	prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
     	
     	System.out.println("--------  Hibernate Properties Created  --------");
     	
     	System.out.println("----  Local Session Factory Builder Object Creating  ----");
     	
     	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
     	sessionBuilder.addProperties(prop);
     	
     	System.out.println("---------  Factory Builder Object Created  --------");
     	
     	sessionBuilder.addAnnotatedClass(Category.class);
     	sessionBuilder.addAnnotatedClass(Product.class);
     	sessionBuilder.addAnnotatedClass(UserDetail.class);
     	

     	System.out.println("----  Session Factory Object Creating  ----");
     	SessionFactory sessionFactory = sessionBuilder.buildSessionFactory();
     	System.out.println("---------  Session Factory Object Created --------");
     	return sessionFactory;
     	
     }
	 
	 @Autowired 
     @Bean(name="txManager")
     public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
     {
     	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
     	
     	return transactionManager;
     }
	 
	  @Autowired
     @Bean(name="categoryDAO")
 	public CategoryDAOImpl getCategoryDAOImpl(SessionFactory sessionFactory)
 	{
 		System.out.println("---------  CategoryDAO Object Creating  ---------");
 		return new CategoryDAOImpl(sessionFactory);
 		
 	}
	 
	 
	 @Autowired
     @Bean(name="productDAO")
 	public ProductDAOImpl getProductDAOImpl(SessionFactory sessionFactory)
 	{
 		System.out.println("----------  ProductDAO Object Creating  ---------");
 		return new ProductDAOImpl(sessionFactory);
 		
 	}
	 
	 
	 @Autowired
     @Bean(name="userDAO")
 	public UserDAOImpl getUserDAOImpl(SessionFactory sessionFactory)
 	{
 		System.out.println("----------  UserDAO Object Creating  ----------");
 		return new UserDAOImpl(sessionFactory);
 		
 	}
	 
	 

}
