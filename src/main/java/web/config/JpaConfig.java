package web.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan("web")
public class JpaConfig {

//    @Autowired
//    private Environment env;

    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Environment.getProperties().getProperty("db.driver"));
        dataSource.setUrl(Environment.getProperties().getProperty("db.url"));
        dataSource.setUsername(Environment.getProperties().getProperty("db.username"));
        dataSource.setPassword(Environment.getProperties().getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(getDataSource());
        factoryBean.setPackagesToScan(new String[]{"web.model"});

        Properties props=new Properties();
        props.setProperty("hibernate.show_sql", Environment.getProperties().getProperty("hibernate.show_sql"));
        props.setProperty("hibernate.hbm2ddl.auto", Environment.getProperties().getProperty("hibernate.hbm2ddl.auto"));
        factoryBean.setJpaProperties(props);

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager getTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
        return transactionManager;
    }
}
