package com.sangin.basic.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sangin.basic.dto.request.student.PostStudentRequestDto;
import com.sangin.basic.service.StudentService;

@Service // 서비스 형태의 spring bean 으로 등록하기
public class StudentServiceImplement implements StudentService {

    @Override
    public ResponseEntity<String> postStudent(PostStudentRequestDto dto) {
        return null;
    }
    
}
