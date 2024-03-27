package com.sangin.basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangin.basic.dto.request.student.PostStudentRequestDto;
import com.sangin.basic.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

//!  JSON 형태를 반환하는 컨트롤러 영역으로 지정해보자
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor        // final 로 지정되어있는 변수들에 관하여 생성자를 생성해준다
public class StudentController {

    private final StudentService studentService;

    // CREATE
    @PostMapping("/")
    public ResponseEntity<String> postStudent(
        @RequestBody @Valid PostStudentRequestDto requestBody
    ) {
        ResponseEntity<String> response = studentService.postStudent(requestBody);
        return response;
    }

    // UPDATE
    @PatchMapping ("/")
    public ResponseEntity<?> patchStudent () {
        return null;
    }

    // DELETE
    @DeleteMapping ("/{studentNumber}")
    public ResponseEntity<?> deleteStudent (
        @PathVariable("studentNumber") Integer studentNumber
    ) {
        return null;
    }
    
}


// body O : GET , DELETE
// body X : POST , PATCH , PUT

// @Valid : PostStudentRequestDto 에 작업한 것들을 응답받도록 만든다
