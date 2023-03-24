package org.project.wearweather;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/css/**","/fonts/**","/images/**","/js/**","/vendor/**", "/user/availability/**","/example","/orderlist","/review", "/addproduct", "/manageproduct", "/orderproduct", "/productdetail", "/user/cart", "/user/mypage", "/user/modify", "/register", "/quituser", "/addressmanage").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/User/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

}