package com.klangham.homeoffice.restsample.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * The Class WebAppInitializer. Replaces the need for web.xml for Servlet 3.0 environments.

 * @author klangham
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {  
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
        ctx.register(WebConfig.class);  
        ctx.setServletContext(servletContext);    
        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
        dynamic.addMapping("/");  
        dynamic.setLoadOnStartup(1);  
   }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Class[] getRootConfigClasses() {
		return new Class[] {CoreConfig.class};
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Class[] getServletConfigClasses() {
		return new Class[] {WebConfig.class};
	}

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
	
}
