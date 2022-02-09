package base.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import base.config.AppDbConfig;
import base.config.AppWebConfig;

//FC: DispatcherServlet using  Annotation Configuration starter
public class AppInit 
	extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//DB Config File input to FC
		return new Class[] {AppDbConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//MVC Config File input to FC
		return new Class[] {AppWebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		//URL Pattern
		return new String[] {"/"};
	}

}
