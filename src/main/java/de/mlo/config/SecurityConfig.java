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


@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = de.mlo.service.UserServiceImpl.class)
@EnableGlobalMethodSecurity(prePostEnabled = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	public void configureGlobal(UserDetailsService userDetailsService,
			AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public Md5PasswordEncoder passwordEncoder() throws Exception {
	  return new Md5PasswordEncoder();
	}
	@Autowired
	AccessDeniedExceptionHandler accessDeniedExceptionHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**").permitAll()
				.antMatchers("/error/**").permitAll()
				.anyRequest().authenticated().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/").permitAll().and()
				.logout().permitAll().and().exceptionHandling()
				.accessDeniedHandler(accessDeniedExceptionHandler);
	}
	

}