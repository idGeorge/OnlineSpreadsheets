package ua.remzsolutions.onlinespreadsheets.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages = {"ua.remzsolutions.onlinespreadsheets.domain.repository"})
@EnableTransactionManagement
public class PersistenceConfiguration {

    private final Environment environment;

    @Autowired
    public PersistenceConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    @Profile("!dev")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driver.class.name"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    @Autowired
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan(environment.getProperty("entity_manager.packages_to_scan"));
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(getHibernateProperties());

        return factoryBean;
    }

    @Bean
    @Autowired
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
        properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.connection.pool_size", environment.getProperty("hibernate.connection.pool_size"));
        properties.setProperty("hibernate.enable_lazy_load_no_trans", environment.getProperty("hibernate.enable_lazy_load_no_trans"));
//        properties.setProperty("hibernate.current_session_context_class", environment.getProperty("hibernate.current_session_context_class"));

        return properties;
    }
}
