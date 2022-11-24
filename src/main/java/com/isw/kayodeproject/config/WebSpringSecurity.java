package com.isw.kayodeproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration //this makes it a spring based config class, where
@EnableWebSecurity //enables spring security's web security support
public class WebSpringSecurity {

    private UserDetailsService userDetailsService;

    public WebSpringSecurity(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // csrf is disabled here, cos it is basically a blog, it is mostly used for banking apps
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .loginProcessingUrl("/login")
                        .permitAll()
                )
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable() // csrf is disabled here, cos it is basically a blog, it is mostly used for banking apps
//                .authorizeRequests()
//                .antMatchers("/resources/static/css/**").permitAll()
//                .antMatchers("/resources/static/images/**").permitAll()
//                .antMatchers("/register/**").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN", "GUEST")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/admin/posts")
//                        .loginProcessingUrl("/login")
//                        .permitAll()
//                )
//                .logout(
//                        logout -> logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .permitAll()
//                );
//        return http.build();
//    }




    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService)  //authenticationmanager will use userdetailsservice to load data from the db and carry out auth
                .passwordEncoder(passwordEncoder());
    }
}
