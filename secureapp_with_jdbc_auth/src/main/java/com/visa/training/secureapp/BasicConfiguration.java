package com.visa.training.secureapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
	@EnableWebSecurity
	public class BasicConfiguration extends WebSecurityConfigurerAdapter {
	 
	    /*@Override
	    protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
	        auth
	          .inMemoryAuthentication()
	          .withUser("user")
	            .password("{noop}password")
	            .roles("USER")
	            .and()
	          .withUser("admin")
	            .password("{noop}admin")
	            .roles("USER", "ADMIN");
	    }*/
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .jdbcAuthentication()
          .dataSource(dataSource())
          .usersByUsernameQuery(
        		   "select username,password, enabled from users where username=?")
          .authoritiesByUsernameQuery(
           "select username, role from user_roles where username=?");
    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	          .authorizeRequests()
	          .anyRequest()
	          .authenticated()
	          .and()
	          .httpBasic();
	    }
	    
	    @Bean(name = "dataSource")
	    public DriverManagerDataSource dataSource() {
	        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/visa");
	        driverManagerDataSource.setUsername("visa");
	        driverManagerDataSource.setPassword("secret");
	        return driverManagerDataSource;
	    }
	}

