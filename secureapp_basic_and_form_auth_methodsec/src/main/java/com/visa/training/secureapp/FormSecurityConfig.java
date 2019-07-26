package com.visa.training.secureapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

public class FormSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests() //

				.antMatchers("/admin/**").hasRole("ADMIN") //
				.antMatchers("/login.html").permitAll().antMatchers("/process_login").permitAll().anyRequest()
				.authenticated().and() //
				.formLogin().loginPage("/login.html").defaultSuccessUrl("/home.html")
				.loginProcessingUrl("/process_login").and() //
				.logout();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("user").password("{noop}password").roles("USER")
		.and()
		.withUser("admin")
		.password("{noop}admin")
		.roles("USER", "ADMIN");
	}

//http://localhost:8080/admin/admin.html
}
