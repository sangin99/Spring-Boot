package com.sangin.basic.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangin.basic.dto.ResponseSampleDTO;


@RestController
// HTTP * localhost:4000/response-data/**
@RequestMapping("/response-data")
public class ResponseDataCotroller {

    // @ResponseEntity :
    // - Response 의 header, status code, status message, data 를 조작할 수 있도록 하는 클래스
    @GetMapping("/{number}") 
    public ResponseEntity<String> getNumber(
        //todo/ <> : 제너릭 지정
        //! {number} 을 값으로 받아오려면 @PathVariable 을 지정해줘야한다.
        @PathVariable("number") Integer number
    ) {
        //todo/ ststus 400 으로 만들기
        // String body = number > 0 ? "양수" : number < 0 ? "음수" : "영";
            //? 방법 1
        // return new ResponseEntity<String>(body, HttpStatusCode.valueOf(400));
            //? 방법 2
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);

        //todo/ EX) _ 양수 : 200 / 영 : 201 / 음수 : 202 보내기 
        ResponseEntity<String> response = null;
        if (number < 0) 
        response = ResponseEntity.status(202).body( "음수");
        if (number == 0)
        response = ResponseEntity.status(201).body("영");
        if (number > 0)
        response = ResponseEntity.status(200).body("양수");

        return response;
    }

    @GetMapping("/response/dto")
    public ResponseEntity<ResponseSampleDTO> getResponseDTO() {
        ResponseEntity<ResponseSampleDTO> response = ResponseEntity.status(201).body(new ResponseSampleDTO("문자열", 99));
        return response;
    }
    
}
