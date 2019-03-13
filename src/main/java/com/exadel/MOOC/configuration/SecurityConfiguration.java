package com.exadel.MOOC.configuration;

import com.exadel.MOOC.security.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myUserDetailService);
        authenticationProvider.setPasswordEncoder(encoder());
        return authenticationProvider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/course/three-latest","/index","/"
                        ,"/resources/static/**","/module/*","/course-page"
                        ,"/course/*","/picture/*","/css/*","/js/*","/security/isAnonymous"
                ,"/lesson-lesson-item","/security/test","/user-to-module/modules-by-course").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .successForwardUrl("/perform_login")
                .defaultSuccessUrl("/index")
                .failureForwardUrl("/")
                .permitAll()
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER);
    }

}
