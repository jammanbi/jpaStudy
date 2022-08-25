package com.jpaStudy.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 스프링 시큐리티 설정
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@ConditionalOnDefaultWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .headers().frameOptions().disable()
            .and()
            .authorizeRequests()                                // httpServletRequest에 따른 접근 제한
                //.antMatchers("/admin/**").hasRole("ADMIN")    // 어드민 권한만 허용
                .antMatchers("/**").authenticated()  //
                .anyRequest().permitAll()      // url에 따른 모두 허용
            .and()
                .formLogin()
                    .loginPage("/user/login")     // 로그인 페이지
                    .usernameParameter("email")
                    .passwordParameter("pwd")
                    .loginProcessingUrl("/login") // 로그인폼 액션 url
                    .permitAll();

        return http.build();
    }
}
