package base.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import base.entity.Employee;
import base.entity.EmployeeBackup;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:app.properties")
public class AppDbConfig {

	@Autowired
	private Environment env;

	@Bean
	public DriverManagerDataSource ds() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("db.driver"));
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.user"));
		ds.setPassword(env.getProperty("db.pwd"));
		return ds;
	}

	//2. SessionFactory
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(ds()); //HAS-A (ref link)
		sf.setAnnotatedClasses(Employee.class, EmployeeBackup.class);
		sf.setHibernateProperties(props());
		return sf;
	}

	private Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect", env.getProperty("orm.dialect"));
		p.put("hibernate.show_sql", env.getProperty("orm.showsql"));
		p.put("hibernate.format_sql", env.getProperty("orm.fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("orm.ddlauto"));
		return p;
	}

	//3. Hibernate Template
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(sf().getObject());
		return ht;
	}

	//4. Hibernate txManager
	@Bean
	public HibernateTransactionManager htxm() {
		HibernateTransactionManager htxm=new HibernateTransactionManager();
		htxm.setSessionFactory(sf().getObject());
		return htxm;
	}
}
