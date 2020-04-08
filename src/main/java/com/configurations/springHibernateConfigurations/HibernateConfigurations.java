package com.configurations.springHibernateConfigurations;

import java.util.List;
import java.util.Properties;


import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableTransactionManagement
@PropertySource(value={"classpath:application.properties"})
@ComponentScan({"com.configurations.springHibernateConfigurations"})
public class HibernateConfigurations {
	
	private static final Logger logger = Logger.getLogger(HibernateConfigurations.class);
	@Autowired
	Environment environment;
	
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean hibernateSessionFactory = new LocalSessionFactoryBean();
		hibernateSessionFactory.setDataSource(dataSource());
		hibernateSessionFactory.setPackagesToScan(new String []{"com.modelTable"});
		hibernateSessionFactory.setHibernateProperties(loadProperties());
		logger.error(HibernateConfigurations.class);
		return hibernateSessionFactory;
	}
	
	
	private Properties loadProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql",environment.getProperty("hibernate.format_sql"));
		return properties;
	}
	
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		driverManagerDataSource.setUrl(environment.getProperty("jdbc.url"));
		driverManagerDataSource.setUsername(environment.getProperty("jdbc.username"));
		driverManagerDataSource.setPassword(environment.getProperty("jdbc.password"));
		return driverManagerDataSource;
	}

	@Bean
	public HibernateTransactionManager hibernateTxnManager(SessionFactory sf)
	{
		HibernateTransactionManager hibTxnMgr = new HibernateTransactionManager();
		hibTxnMgr.setSessionFactory(sf);
		return hibTxnMgr;
				
	}

}
