package com.sangin.basic.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sangin.basic.filter.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration

// @Configurable :
// - 생성자나 '메서드'가 호출시에 Spring bean 등록을 자동화(제어 역전)하는 어노테이션
@Configurable
// @EnableWebSecurity :
// - Web Security 설정을 지원하도록 하는 어노테이션 
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    
    // @Bean :
    // - Spring bean 으로 등록하는 어노테이션
    // - @Component 를 사용하지 못할 때 사용
    // - @Autowired 의 목적이 아닐 때 사용
    @Bean
    protected SecurityFilterChain configure(HttpSecurity security) throws 
    Exception {
        // class::method :
        // - 메소드 참조, 특정 클래스에 메서드를 참조할 때 사용
        // - 일반적으로 매개변수로 메서드를 전달할 때 사용됨
        security
        // basic authentication 미사용 지정
        .httpBasic(HttpBasicConfigurer::disable);
        // session :
        // - 웹 애플리케이셔에서 사용자에 대한 정보 및 상태를 유지하기 위한 기술
        // - 서버측에서 사용자 정보 및 상태를 저장하는 방법
        // - REST API 서버에서는 사용자 정보 및 상태를 클라이언트가 유지하기 때문에 session 을 생성하지 않음

        // cookie : 
        // - 웹 애플리케이션에서 사용자에 대한 정보 및 상태를 유지하기 위한 기술
        // - 클라이언트측에서 사용자 정보 및 상태를 저장하는 방법
        
        // session 과 cookie 의 차이 : 
        // - 저장위치 : cookie - 클라이언트, session - 서버
        // - 보안 : session 이 보안 수준이 높음
        // - 수명 : cookie 는 지정한 기간동안 지속적으로 유지가능 , session 은 연결이 끊기면 파기됨
        // - 용도 : cookie 에는 간단한 데이터(id, token..)를 저장 , session 에는 민감한 데이터(개인정보..)를 저장
        
        // cache : 
        // - 데이터나 값을 미리 복사해두고 저장하는 임시 공간
        // - 사용자의 접근을 조금 더 빠르게 할 수 있도록 함
        // - 시스템 성능 향상
        // - 하드웨어 캐시   : cpu cache, disk cache
        // - 소프트웨어 캐시 : web cache, database cache
        // - 네트워크 캐시   : CDN
        .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        // CSRF (Cross-Site Request Forgery) : 
        // - 클라이언트(사용자)가 자신의 의도와는 무관한 공격 행위를 하는 것
        // - 보안 취약점 -
        // SQL Injection : 
        // - 공격자가 데이터베이스의 쿼리문을 직접 조작하여 데이터를 탈취하는 공격
        // XSS (Cross-Site Scripting) :
        // - 공격자가 웹 브라우저에 악성 스크립트를 작성하여 실행시키는 공격
        .csrf(CsrfConfigurer::disable);

        // 우리가 생성한 jwtAuthenticationFilter 를 UsernamePasswordAuthenticationFilter 이전에 등록
        security.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return security.build();
    }

}
