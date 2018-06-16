package com.org.Configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInt  extends AbstractAnnotationConfigDispatcherServletInitializer
{

	public WebAppInt(){
    	System.out.println("WebAppInitializer class is loaded and Instantiated");
    }
	
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{DatabaseConfig.class};
	}

	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{WebAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};// <url-pattern>/</url-pattern> Any requests,it will forwarded to DispatcherServlet
	}

}

