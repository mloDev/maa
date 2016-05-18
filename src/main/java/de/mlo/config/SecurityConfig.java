package de.mlo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import de.mlo.exception.AccessDeniedExceptionHandler;


// TODO: Auto-generated Javadoc
/**
 * The Class SecurityConfig.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = de.mlo.service.UserServiceImpl.class)
@EnableGlobalMethodSecurity(prePostEnabled = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	/**
	 * Configure global.
	 *
	 * @param userDetailsService the user details service
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Autowired
	public void configureGlobal(UserDetailsService userDetailsService,
			AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	/**
	 * Password encoder.
	 *
	 * @return the md5 password encoder
	 * @throws Exception the exception
	 */
	@Bean
	public Md5PasswordEncoder passwordEncoder() throws Exception {
	  return new Md5PasswordEncoder();
	}
	
	/** The access denied exception handler. */
	@Autowired
	AccessDeniedExceptionHandler accessDeniedExceptionHandler;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**").permitAll()
				.antMatchers("/error/**").permitAll().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/").permitAll().and()
				.logout().permitAll().and().exceptionHandling()
				.accessDeniedHandler(accessDeniedExceptionHandler);
	    http.authorizeRequests().antMatchers("/").permitAll().and()
          .authorizeRequests().antMatchers("/console/**").permitAll();

	    http.csrf().disable();
	    http.headers().frameOptions().disable();
	}
	

}