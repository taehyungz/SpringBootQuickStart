package com.rubypaper.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.userDetailsService(userDetailsService);

        //모든 사용자 접근(인증 안 함 포함)
        security.authorizeRequests().antMatchers("/", "/system/**").permitAll();
        //인증된 사용자만 접근
        security.authorizeRequests().antMatchers("/board/**").authenticated();
        //ADMIN만 접근
        security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

        security.csrf().disable();
        //인증되지 않은 사용자가 '/board'로 시작하는 경로를 요청한 경우 '/system/login'으로 리다이렉트
        //로그인 성공시 '/board/getBoardList'로 리다이렉트
        security.formLogin().loginPage("/system/login").defaultSuccessUrl("/board/getBoardList", true);
        security.exceptionHandling().accessDeniedPage("/system/accessDenied");
        security.logout().logoutUrl("/system/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
