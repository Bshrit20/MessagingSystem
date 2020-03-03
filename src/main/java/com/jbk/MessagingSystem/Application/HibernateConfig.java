package com.jbk.MessagingSystem.Application;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.jbk.MessagingSystem.Bean.School;

@Configuration
@EnableJpaAuditing
public class HibernateConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

		// Add your own Bean Class name //sessionFactory.setAnnotatedClasses(BeanClass
		// Name);
		sessionFactory.setAnnotatedClasses(School.class);

		return sessionFactory;
	}

}
