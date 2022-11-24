//package com.isw.kayodeproject.config2;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//    @EnableWebSecurity
//    public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////        @Bean
////        public UserDetailsService getUserDetailsService() {
////            return new UserDetailsServiceImpl();
////        }
//
//        @Bean
//        public BCryptPasswordEncoder getPasswordEncoder() {
//            return new BCryptPasswordEncoder();
//        }

//        @Bean
//        public DaoAuthenticationProvider getDaoAuthProvider() {
//            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//            daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
//            daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
//
//            return daoAuthenticationProvider;
//        }

//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.authenticationProvider(getDaoAuthProvider());
//        }

//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            String[] staticResources = {
//                    "/css/**",
//                    "/images/**",
//                    "/plugins/**",
//                    "/js/**" };
//
//            http.authorizeRequests()
//                    .antMatchers("/admin/**")
//                    .hasRole("ADMIN")
//                    .antMatchers("/users/**")
//                    .permitAll()
////                    .hasRole("USER")
//                    .antMatchers(staticResources)
//                    .permitAll()
//                    .antMatchers("/**")
//                    .permitAll()
//
//                    .and()
//                    .formLogin().loginPage("/login")
//                    .loginProcessingUrl("/login")
//                    .defaultSuccessUrl("/users/")
//                    .permitAll()
//
//                    .and()
//                    .logout()
//                    .invalidateHttpSession(true)
//                    .clearAuthentication(true)
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                    .logoutSuccessUrl("/")
//                    .permitAll()
//
//                    .and()
//                    .csrf()
//                    .disable();
//        }
//}
