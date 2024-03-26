package com.sangin.basic.service.implement;

import org.springframework.stereotype.Service;

import com.sangin.basic.service.BasicService;

//  Service 레이어 : 
// - 실제 비즈니스 로직(연산)을 실행하는 영역
// - 트랜잭션 처리나 유효성 검사(직전 비즈니스  로직 결과에 대한)를 수행하기도 함
// - Controller 로 부터 받은 요청 데이터에 대해서 필요에 따라 Repository 등을 거쳐 연산을 진행하고 Controller 에 응답에 대한 데이터 반환

// Service : 해당 클래스를 Spring Bean 으로 등록하는 어노테니션, 역할은  @Component 와 동일
// @Component : 해당 클래스를 Spring Bean 으로 등록하는 어노테이션
// @Spring Bean : 제어의 역전을 통해서 의존성 주입시 해당 클래스의 인스턴스를 Spring Framework 가 제어하는 요소 .  Spring Framework 제어하는 인스턴스
@Service  
public class BasicServiceImplement implements BasicService {

    @Override
    public String getHello() {
        return "Hello Springboot!!";
    }

	@Override
	public String getApple() {
        return "Get Mapping 으로 만든 메서드";
    }
    
}