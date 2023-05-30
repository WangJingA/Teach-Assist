package com.boot.teach.common.config.security;


import com.boot.teach.common.exception.AccessDeniedHandlerImpl;
import com.boot.teach.common.exception.AuthenticationEntryPointImpl;
import com.boot.teach.common.exception.AuthenticationException;
import com.boot.teach.common.filters.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccessDeniedHandlerImpl accessDeniedHandler;

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    AuthenticationEntryPointImpl entryPoint;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .httpBasic().disable()
                //表单提交disable
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //放行的请求配置，不需要经过验证
                .antMatchers("/login/**","/captcha/**").anonymous()
                .anyRequest()
                .authenticated();
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling()
                .authenticationEntryPoint(entryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
