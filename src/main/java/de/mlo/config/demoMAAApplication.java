package de.mlo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import de.mlo.exception.AccessDeniedExceptionHandler;
import groovy.lang.Grab;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "de.mlo" })
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "de.mlo.repository")
@EntityScan(basePackages = "de.mlo.model")
@Grab("org.webjars:jquery:1.11.4") // this will automatically fetch jquery
public class demoMAAApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(demoMAAApplication.class, args);
	}
	
	@Value("${init.json}")
	private String init;

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/login").setViewName("login");
			registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		}

		@Bean
		AccessDeniedExceptionHandler accessDeniedExceptionHandler() {
			AccessDeniedExceptionHandler accessDeniedExceptionHandler = new AccessDeniedExceptionHandler();
			accessDeniedExceptionHandler.setErrorPage("/error/accessDeniedPage");
			return accessDeniedExceptionHandler;
		}


		// Maps resources path to webapp/resources
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/resources/**").addResourceLocations(
					"/resources/");
		}

		// Provides internationalization of messages
		@Bean
		public ResourceBundleMessageSource messageSource() {
			ResourceBundleMessageSource source = new ResourceBundleMessageSource();
			source.setBasename("messages");
			return source;
		}
		
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
