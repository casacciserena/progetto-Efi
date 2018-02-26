package com.serena.animalproject.configuration;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.serena.animalproject"})
@PropertySource(value = {"classpath:application.properties"})
public class DatabaseConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.serena.animalproject"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
        dataSource.setUsername(environment.getRequiredProperty("db.username"));
        dataSource.setPassword(environment.getRequiredProperty("db.password"));
        dataSource.setUrl(environment.getRequiredProperty("db.url"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        String hbm2ddl = environment.getRequiredProperty("hibernate.hbm2ddl.auto");
        if(hbm2ddl != null && !"".equalsIgnoreCase(hbm2ddl)) {
            properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
        }
        properties.put("db.username", environment.getRequiredProperty("db.username"));
        properties.put("db.password", environment.getRequiredProperty("db.password"));
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}

//@Configuration
//@EnableTransactionManagement
//public class DatabaseConfiguration {
//
//    // Private fields
//    @Autowired
//    private Environment environment;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private LocalContainerEntityManagerFactoryBean entityManagerFactory;
//
//
//    /**
//     * DataSource definition for database connection. Settings are read from
//     * the application.properties file (using the env object).
//     */
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getProperty("db.driver"));
//        dataSource.setUrl(environment.getRequiredProperty("db.url"));
//        dataSource.setUsername(environment.getProperty("db.username"));
//        dataSource.setPassword(environment.getProperty("db.password"));
//        return dataSource;
//    }
//
//    /**
//     * Declare the JPA entity manager factory.
//     */
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//
//        entityManagerFactory.setDataSource(dataSource);
//
//        // Classpath scanning of @Component, @Service, etc annotated class
//        entityManagerFactory.setPackagesToScan(environment.getProperty("entitymanager.packagesToScan"));
//
//        // Vendor adapter
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
//
//        // Hibernate properties
//        Properties additionalProperties = new Properties();
//        additionalProperties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
//        additionalProperties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
//        additionalProperties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
//        additionalProperties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
//        entityManagerFactory.setJpaProperties(additionalProperties);
//
//        return entityManagerFactory;
//    }
//
//    /**
//     * Declare the transaction manager.
//     */
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
//        return transactionManager;
//    }
//
//    /**
//     * PersistenceExceptionTranslationPostProcessor is a bean post processor
//     * which adds an advisor to any bean annotated with Repository so that any
//     * platform-specific exceptions are caught and then rethrown as one
//     * Spring's unchecked data access exceptions (i.e. a subclass of
//     * DataAccessException).
//     */
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//}
