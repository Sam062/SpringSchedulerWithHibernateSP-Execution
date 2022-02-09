package base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("base")
@PropertySource("classpath:app.properties")
public class AppWebConfig {

	@Autowired
	private Environment env;

	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver ivr=new InternalResourceViewResolver();

		ivr.setPrefix(env.getProperty("mvc.prefix"));
		ivr.setSuffix(env.getProperty("mvc.suffix"));

		return ivr;
	}

}
