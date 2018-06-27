package com.javasampleapproach.webflux.model;

import org.springframework.context.annotation.Bean;

//@EnableWebFluxSecurity
public class HelloWebfluxSecurityConfig {
	
//	Minimal Configuration
	
//	@Bean
//	public MapReactiveUserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder()
//			.username("user")
//			.password("user")
//			.roles("USER")
//			.build();
//		return new MapReactiveUserDetailsService(user);
//	}

	
	
	
	
	
	
	
	
//
//	Explicit Configuration
	
	
//	@Bean
//	public MapReactiveUserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder()
//			.username("user")
//			.password("user")
//			.roles("USER")
//			.build();
//		return new MapReactiveUserDetailsService(user);
//	}
//	
//	@Bean
//	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//		http
//			.authorizeExchange()
//				.anyExchange().authenticated()
//				.and()
//			.httpBasic().and()
//			.formLogin();
//		return http.build();
}
}