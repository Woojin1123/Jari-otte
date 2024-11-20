package com.eatpizzaquickly.datasourcecommon.config;

import com.eatpizzaquickly.datasourcecommon.enums.OperationType;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Bean(name = "writeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource writeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource readDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSource routingDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(OperationType.WRITE, writeDataSource());
        dataSourceMap.put(OperationType.READ, readDataSource());

        ReplicationDatasourceRouter routingDataSource = new ReplicationDatasourceRouter();
        routingDataSource.setDefaultTargetDataSource(writeDataSource());
        routingDataSource.setTargetDataSources(dataSourceMap);
        routingDataSource.afterPropertiesSet();

        return routingDataSource;
    }
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManagerFactoryBean.setPackagesToScan(
                "com.eatpizzaquickly.userservice.entity",
                "com.eatpizzaquickly.concertservice.entity",
                "com.eatpizzaquickly.reservationservice.reservation.entity",
                "com.eatpizzaquickly.reservationservice.payment.entity",
                "com.eatpizzaquickly.reservationservice.review.entity",
                "com.eatpizzaquickly.couponservice.entity"
                );
        entityManagerFactoryBean.setDataSource(new LazyConnectionDataSourceProxy(routingDataSource()));
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);

        return entityManagerFactoryBean;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.use_sql_comments", "true");
        properties.put("hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
        properties.put("hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");

        return properties;
    }
    @Primary
    @Bean
    public DataSource dataSource(DataSource routingDataSource) {
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource routingDatasource) {
        return new JdbcTemplate(new LazyConnectionDataSourceProxy(routingDatasource));
    }
}

