package com.example.h2demo.book.config;

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
@EnableJpaRepositories(entityManagerFactoryRef = "bookEntityManagerFactory", transactionManagerRef = "bookTransactionManager", basePackages = {
		"com.example.h2demo.book.repo" })
public class BookConfig {
	@Primary
	@Bean(name = "bookDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.book")
	public DataSource bookDataSource() {
		 return DataSourceBuilder.create().build(); 
	}

	@Primary
	@Bean(name = "bookEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("bookDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.example.h2demo.book.data").persistenceUnit("db1").build();
	}

	@Primary
	@Bean(name = "bookTransactionManager")
	public PlatformTransactionManager bookTransactionManager(
			@Qualifier("bookEntityManagerFactory") EntityManagerFactory bookEntityManagerFactory) {
		return new JpaTransactionManager(bookEntityManagerFactory);
	}
}
