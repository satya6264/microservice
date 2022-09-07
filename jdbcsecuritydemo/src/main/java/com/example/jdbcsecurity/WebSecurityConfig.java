package com.example.jdbcsecurity;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(NoOpPasswordEncoder.getInstance())
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from users where username=?");
		
		
	}
	/*
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll();
	}
	*/
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.
	                httpBasic()
	                .and()
	                .authorizeRequests()
	                .antMatchers("/deleteUser").hasRole("ADMIN")
	                //.antMatchers("/delete").hasRole("admin")
	                .antMatchers("/getDetails").hasAnyRole("ADMIN","USER")
	                .and()
	                .formLogin().permitAll()
	                .and()
	                .logout().permitAll();
	    }

}
