package com.ibcs.primax.jwt.security;

import com.ibcs.primax.jwt.filter.JwtTokenVerifierFilter;
import com.ibcs.primax.jwt.filter.JwtUsernamePasswordAuthenticationFilter;
import com.ibcs.primax.jwt.jwtService.CustomEmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author tuhin
 * @created_on 7/6/21 at 12:59 AM
 * @project primax
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,proxyTargetClass = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomEmployeeDetailsService customEmployeeDetailsService;

    @Autowired
    JwtTokenVerifierFilter jwtTokenVerifierFilter;

    /**
     *
     * @param auth
     * @throws Exception
     * @Description configure Authentication manager to authenticate Employee
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customEmployeeDetailsService);
    }

    /**
     *
     * @param security
     * @throws Exception
     * @Description though i am not use Role base permission, here i permit some of my api public,
     *
     */

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        /**
         * Here I used 2 filter, Authentication Filter & Token Verifier Filter
         */

        security.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifierFilter(), JwtUsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .anyRequest()
                .authenticated();

        security.addFilterBefore(jwtTokenVerifierFilter, UsernamePasswordAuthenticationFilter.class);

    }





    /**
     *
     * @return
     * @throws Exception
     *
     * mange authentication
     */

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     *
     * @return encoded password using Base64 algorithm
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
