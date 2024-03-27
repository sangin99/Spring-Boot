package com.sangin.basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sangin.basic.dto.request.student.PostStudentRequestDto;
import com.sangin.basic.entity.StudentEntity;
import com.sangin.basic.repository.StudentRepository;
import com.sangin.basic.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service // 서비스 형태의 spring bean 으로 등록하기
@RequiredArgsConstructor
public class StudentServiceImplement implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public ResponseEntity<String> postStudent(PostStudentRequestDto dto) {
        
        // StudentEntity studentEntity = new StudentEntity();   // 인스턴스 만들기
        // studentEntity.setName(dto.getName());
        // studentEntity.setAge(dto.getAge());
        // studentEntity.setAddress(dto.getAddress());
        // studentEntity.setGraduation(dto.getGraduation());

        //! StudentEntity 에 생성해놓고 받아온다 / 위의 식과 동일
        // CREATE (SQL : INSERT)
        // 1. Entity 클래스의 인스턴스 생성
        // 2. 생성한 인스턴스를 repository.save() 메서드로 저장
        StudentEntity studentEntity = new StudentEntity(dto);   // 인스턴스 만들기
        // save() : 저장 및 수정(덮어쓰기)
        StudentEntity savedEntity = studentRepository.save(studentEntity);   // 데이터베이스 저장이 된다

    
        return ResponseEntity.status(HttpStatus.CREATED).body("성공!");    // CREATED : status:201
    } 

}


//todo\\ JAVA -> App.java 함께 보며 java - spring 공부해보기
