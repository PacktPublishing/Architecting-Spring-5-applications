package com.springbootdev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("app_user").password("test123").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("test123").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().
                realmName("spring-app").
                and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().csrf().disable().
                authorizeRequests().antMatchers("/guest/**").permitAll().anyRequest().authenticated();

    }

    @Bean
    public NoOpPasswordEncoder passwordEncoder()
    {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
