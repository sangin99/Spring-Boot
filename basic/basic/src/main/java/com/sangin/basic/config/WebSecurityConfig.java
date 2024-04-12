package com.sangin.basic.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

// @Configurable :
// - 생성자나 '메서드'가 호출시에 Spring bean 등록을 자동화(제어 역전)하는 어노테이션
@Configurable

// @EnableWebSecurity :
// - Web Security 설정을 지원하도록 하는 어노테이션 
@EnableWebSecurity

public class WebSecurityConfig {
    
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
        return security.build();
    }

}
