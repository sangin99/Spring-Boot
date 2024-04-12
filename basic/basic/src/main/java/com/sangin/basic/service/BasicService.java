package com.sangin.basic.service;

public interface BasicService {
    // interface 의 메서드는 반드시  public abstract 이어야 함      //  interface : 반드시 선언부만 존재
    // public abstract String getHello();   

    // public abstract 제어자는 생략해도 됨
    String getHello();
    String getApple();
    

    String getJwt(String priciple);
    String jwtValidate(String jwt);
}
