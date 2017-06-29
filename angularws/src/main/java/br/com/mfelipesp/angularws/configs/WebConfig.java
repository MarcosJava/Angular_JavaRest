package br.com.mfelipesp.angularws.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {
	
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/WEB-INF/jsp/", "classpath:/resources/",
			"classpath:/static/", "classpath:/public/" };
	
	
	/***
	 * CORS serve para acessos a JavaScript, Jquery e AngularJS
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/").allowedOrigins("http://localhost:8080");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("forward:/index.html");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (!registry.hasMappingForPattern("/restApi/**")) {
			registry.addResourceHandler("/restApi/**").addResourceLocations("classpath:/WEB-INF/jsp/");
		}
		if (!registry.hasMappingForPattern("/**")) {
			registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
		}
	}
	
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
	    InternalResourceViewResolver resolver= new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/jsp/");
	    resolver.setSuffix(".html");
	    return resolver;
	}  
	
}
