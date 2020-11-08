package com.rkc.zds.books.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.DerbyTenSevenDialect;
import org.hibernate.dialect.MySQL55Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.rkc.zds" }, excludeFilters = { @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION) })
@EnableJpaRepositories(basePackages = { "com.rkc.zds" })
@EnableTransactionManagement
@EnableSpringDataWebSupport
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("book_user");
		dataSource.setPassword("ChangeIt");
		
		// dataSource.setUrl("jdbc:mysql://localhost:3306/auth?createDatabaseIfNotExist=true");
		dataSource.setUrl("jdbc:mysql://localhost:3306/books?createDatabaseIfNotExist=true&serverTimezone=UTC&useLegacyDatetimeCode=false");

		return dataSource;
	}    

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPersistenceUnitName("books");

        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("com.rkc.zds");
      
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", MySQL55Dialect.class.getName());
		//jpaProperties.put("hibernate.show_sql", Boolean.TRUE.toString());
		jpaProperties.put("hibernate.show_sql", Boolean.FALSE.toString());
		
		jpaProperties.put("hibernate.query.jpaql_strict_compliance", Boolean.FALSE.toString());
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
		jpaProperties.put("driverClassName","com.mysql.jdbc.Driver");
		jpaProperties.put("url","jdbc:mysql://localhost:3306/books?createDatabaseIfNotExist=true&serverTimezone=UTC&useLegacyDatetimeCode=false");
		jpaProperties.put("userName" ,"book_user");
		jpaProperties.put("password" ,"ArcyAdmin8246+");
		factoryBean.setJpaProperties(jpaProperties);

        return factoryBean;
    }

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
