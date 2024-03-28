//  Student 비즈니스 로직을 작업한다

package com.sangin.basic.service;

import org.springframework.http.ResponseEntity;

import com.sangin.basic.dto.request.student.PatchStudentRequestDto;
import com.sangin.basic.dto.request.student.PostStudentRequestDto;

public interface StudentService {     // interface 기본으로  interface , 
    ResponseEntity<String> postStudent(PostStudentRequestDto dto);
    ResponseEntity<String> patchStudent(PatchStudentRequestDto dto);
    ResponseEntity<String> deleteStudent(Integer studentNumber);
}
