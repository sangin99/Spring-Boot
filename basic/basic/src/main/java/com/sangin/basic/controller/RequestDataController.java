package com.sangin.basic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sangin.basic.dto.SampleDTO;

@RestController
// HTTP * localhost:4000/request-data/**  => 을 받고싶으면? "@RequestMapping"
@RequestMapping("/request-data")
public class RequestDataController {

    // @RequestParam() : 
    // - GET, DELETE 처럼 URL 로 데이터를 전송하는 메서드에서 Query String 으로 지정된 데이터를 가져오기 위해 사용 
    
    // HTTP GET localhost:4000/request-data/request-param   => 을 받고싶으면?
    @GetMapping("/request-param")
    // http://localhost:4000/request-data/request-param?userId=qwer&userName=gildong
    public String getRequestParam(
        @RequestParam(name="userId") String userId,
        @RequestParam(name="userName", required = false) String userName,    // required = false : 필수 값이 아니다로 지정
        @RequestParam() int userAge       // 불안정한 식
    ) {
        return "사용자 아이디 : " + userId + "/ 사용자 이름 : " + userName + "/ 사용자 나이 : " + userAge;
    }

    // @PathVariable() :
    // - 모든 HTTP 메서드에서 URL 의 특정 패턴에 따라서 데이터를 추출하는 방식
    
    // HTTP DELETE localhost:4000/request-data/path-variable
    @DeleteMapping ({
        "/path-variable/{age}/{name}",
        "/path-variable/{age}"
    })   //? 여러개를 지정하겠다 : {}
    // http://localhost:4000/request-data/path-variable/10
    public String deletePathVariable(
        @PathVariable("age") Integer age,   //*integer = null 값이 들어온다 / int도 가능은 한데 값이 0으로 떠서 사용자가 0을 입력한 거랑 혼동이 올 수 있다
        @PathVariable(name="name", required = false) String name    // name 값이 필수는 아니다
    ) {
        return "사용자 나이 : " + age + "/ 사용자 이름 : " + name;
    }

    // HTTP PATCH localhost:4000/request-data/patch/gildong/update
    @PatchMapping("/patch/{userName}/update")
    public String patchUpdate(
        @PathVariable("userName") String userName
    ) {
        return "사용자 이름 : " + userName;
    }

    //* ★======주의=======주의======주의========★
    //* URL 패턴으로 데이터를 받아오는 방식을 썼을 때
    //*  겹치는 패턴이 존재하는 잘 확인해야함 */
    @GetMapping("/{value}/get")
    public String getPathVariable1 (
        @PathVariable("value") String value
    ) {
        return "getPathVariable1";
    }

    @GetMapping("/get/{value}")
    public String getPathVariable2 (
        @PathVariable("value") String value
    ) {
        return "getPathVariable2";
    }

// !===============================================================================! //
    
// @RequestBody() : 
    // - POST, PATCH, PUT 처럼 RequestBody 로 데이터를 전송하는 메서드에서 데이터를 가져오기 위해 사용
    
    // HTTP POST localhost:4000/request-data/post
    @PostMapping("/post")
    public String post(
        // @RequestBody String text
        @RequestBody SampleDTO dto
    ) {
        return "전송한 데이터 : " + dto.toString();
    }

}
