package com.example.pandemikent.Security;

import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    private DataSource dataSource;
     
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        // add password encryptor
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, true from user_acc where username=?")
            .authoritiesByUsernameQuery("select user_login_username, role from roles where user_login_username=?")
        ;
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests()
        //     .antMatchers("/submit")
        //     .permitAll()
        //     .antMatchers("/displayProfile")
        //     .hasRole("USER")
        //     .anyRequest().authenticated()
        //     .and()
        //     .formLogin().permitAll()
        //     .and()
        //     .logout().permitAll();     
        http.authorizeRequests()
            .antMatchers("**")
            .permitAll()
            ;
        http.csrf().disable();     // temp testing setting
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}