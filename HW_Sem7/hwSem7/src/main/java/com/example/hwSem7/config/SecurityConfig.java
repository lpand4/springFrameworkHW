package com.example.hwSem7.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * Переопределение возможностей захода на страницу private(только ADMIN) и public(только авторизованные)
     * Для смены страницы аутентификации можно явно указать .loginPage("/login"),
     * но тогда нужно иметь кастомную обработку полученных данных
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/private").hasRole("ADMIN")
                    .antMatchers("/public").authenticated()
                .and()
                    .formLogin()
                        //.loginPage("/login")
                        .permitAll()
                .and()
                    .logout()
                        .logoutSuccessUrl("/login");
    }

    /**
     * Внесение в память двух пользователей, один с ролью USER, один с ролью ADMIN
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("ADMIN");
    }


}
