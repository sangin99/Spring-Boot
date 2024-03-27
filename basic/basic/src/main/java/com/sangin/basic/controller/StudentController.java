package com.sangin.basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//!  JSON 형태를 반환하는 컨트롤러 영역으로 지정해보자
@RestController
@RequestMapping("/student")
public class StudentController {

    // CREATE
    @PostMapping("/")
    public ResponseEntity<?> postStudent() {
        return null;
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
