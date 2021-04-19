package com.rubypaper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity //이 클래스로부터 생성도니 객체가 시큐리티 설정파일임을 의미, 시큐리티를 사용하는데 필요한 수많은 객체 생성
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests().antMatchers("/").permitAll();
        security.authorizeRequests().antMatchers("/member/**").authenticated();
        security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
        security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

        security.csrf().disable(); //RESTful을 사용하기 위해서는 비활성화 해야 한다.
        security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true); //스프링 기본 로그인 페이지 말고 사용자 정의 로그인 페이지 사용
        security.exceptionHandling().accessDeniedPage("/accessDenied"); //권한 없는 페이지 접근시 적절한 권한이 없어서 해당 페이지를 볼 수 없다는 메시지를 보여주기

        //logout() 뒤에 invalidateHttpSession(true)를 사용하여 현재 브라우저와 연관된 세션을 강제 종료
        // cookie도 삭제하고 싶으면 deleteCookies()메소드를 뒤에 추가로 사용
        //logoutSuccessUrl()메소드를 통해 로그아웃 한 후에 이동할 화면으로 리다이렉트함
        security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");

    }

    //인증하지 않은 유저가 인증자들만 들어갈 수 있는 페이지를 요청하면 로그인 페이지로 이동
    @Autowired
    public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().
                withUser("manager").
                password("{noop}manager123").
                roles("MANAGER");

        auth.inMemoryAuthentication().
                withUser("admin").
                password("{noop}admin123").
                roles("ADMIN");
    }
}
