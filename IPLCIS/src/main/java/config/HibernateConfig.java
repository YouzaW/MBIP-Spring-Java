package config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages =  {"config", "controllers", "service", "entity", "util"})
public class HibernateConfig implements WebMvcConfigurer {
	
	@Bean
	public DataSource datasource() {
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	     dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	     dataSource.setUrl("jdbc:mysql://localhost:3306/springdb");
	     dataSource.setUsername("root");
	     dataSource.setPassword("");
	     return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan("entity");
		
		Properties  hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		sessionFactoryBean.setHibernateProperties(hibernateProperties);
        return sessionFactoryBean;
	}
	
	@Bean
    public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory.getObject());
        return transactionManager;
    }
	
}
