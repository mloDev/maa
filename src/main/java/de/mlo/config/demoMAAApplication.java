package de.mlo.config;


import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import de.mlo.exception.AccessDeniedExceptionHandler;
import groovy.lang.Grab;


// TODO: Auto-generated Javadoc
/**
 * The Class demoMAAApplication.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "de.mlo" })
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "de.mlo.repository")
@EntityScan(basePackages = "de.mlo.model")
@Grab("org.webjars:jquery:1.11.4") // this will automatically fetch jquery
public class demoMAAApplication extends WebMvcConfigurerAdapter{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(demoMAAApplication.class, args);
	}
	
	/** The init. */
	@Value("${init.json}")
	private String init;

		/* (non-Javadoc)
		 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
		 */
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/login").setViewName("login");
			registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		}

		/**
		 * Access denied exception handler.
		 *
		 * @return the access denied exception handler
		 */
		@Bean
		AccessDeniedExceptionHandler accessDeniedExceptionHandler() {
			AccessDeniedExceptionHandler accessDeniedExceptionHandler = new AccessDeniedExceptionHandler();
			accessDeniedExceptionHandler.setErrorPage("/error/accessDeniedPage");
			return accessDeniedExceptionHandler;
		}
		
	    /**
    	 * H2servlet registration.
    	 *
    	 * @return the servlet registration bean
    	 */
    	@Bean
	    ServletRegistrationBean h2servletRegistration(){
	        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
	        registrationBean.addUrlMappings("/console/*");
	        return registrationBean;
	    }


		/* (non-Javadoc)
		 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
		 */
		// Maps resources path to webapp/resources
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/resources/**").addResourceLocations(
					"/resources/");
		}

		/**
		 * Message source.
		 *
		 * @return the resource bundle message source
		 */
		// Provides internationalization of messages
		@Bean
		public ResourceBundleMessageSource messageSource() {
			ResourceBundleMessageSource source = new ResourceBundleMessageSource();
			source.setBasename("messages");
			return source;
		}
		
	    /**
    	 * Repository populator.
    	 *
    	 * @return the jackson2 repository populator factory bean
    	 */
    	@Bean
	    public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
	    	Resource sourceData;
	    	Jackson2RepositoryPopulatorFactoryBean factory;
			try {
				sourceData = new PathResource(init);
				if(!sourceData.exists())
					sourceData = new ClassPathResource(init);
				factory = new Jackson2RepositoryPopulatorFactoryBean();
				factory.setResources(new Resource[] { sourceData });
			} catch (Exception e) {
				return null;
			}

			return factory;
	    }

}
