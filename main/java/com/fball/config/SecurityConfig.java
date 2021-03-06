package com.fball.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter  {
		
	
		@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.antMatchers("/","/login","/check_login","/logout","/registy","/new_player","/new_club").permitAll()
					.antMatchers("/notifi", "/profile", "/update_profile","/change_password","/club","/view_add_sttClub","/add_sttClub","/set_time", "/match_stt_club/**", "/virtual_match/**").hasAnyRole("player")
					.antMatchers("/notifiManager").hasAnyRole("manager")
					.anyRequest().denyAll()
				.and()
				.formLogin()
					.loginPage("/login");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(new CustomAuthenticationProvider());
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web	.ignoring()
				.antMatchers("/static/**");
	}
	
}
