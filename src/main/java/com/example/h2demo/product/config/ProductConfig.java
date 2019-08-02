package com.example.h2demo.product.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "productEntityManagerFactory", transactionManagerRef = "productTransactionManager", basePackages = {
		"com.example.h2demo.product.repo" })
public class ProductConfig {
	@Primary
	@Bean(name = "productDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.product")
	public DataSource productDataSource() {
		 return DataSourceBuilder.create().build(); 
	}

	@Primary
	@Bean(name = "productEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("productDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.example.h2demo.product.data").persistenceUnit("db1").build();
	}

	@Primary
	@Bean(name = "productTransactionManager")
	public PlatformTransactionManager bookTransactionManager(
			@Qualifier("productEntityManagerFactory") EntityManagerFactory productEntityManagerFactory) {
		return new JpaTransactionManager(productEntityManagerFactory);
	}
}
