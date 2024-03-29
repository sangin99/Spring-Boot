package com.sangin.basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sangin.basic.dto.request.student.PatchStudentRequestDto;
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
        
//          StudentEntity studentEntity = new StudentEntity();   // 인스턴스 만들기
//          studentEntity.setName(dto.getName());
//          studentEntity.setAge(dto.getAge());
//          studentEntity.setAddress(dto.getAddress());
//          studentEntity.setGraduation(dto.getGraduation());

        //! StudentEntity 에 생성해놓고 받아온다 / 위의 식과 동일 
        // CREATE (SQL : INSERT)
        // 1. Entity 클래스의 인스턴스 생성
        // 2. 생성한 인스턴스를 repository.save() 메서드로 저장
        StudentEntity studentEntity = new StudentEntity(dto);   // 인스턴스 만들기
        // save() : 저장 및 수정(덮어쓰기)
        StudentEntity savedEntity = studentRepository.save(studentEntity);   // 데이터베이스 저장이 된다

    
        return ResponseEntity.status(HttpStatus.CREATED).body("성공!");    // CREATED : status:201
    }
    
    @Override
    public ResponseEntity<String> patchStudent(PatchStudentRequestDto dto) {

        Integer studentNumber = dto.getStudentNumber();
        String address = dto.getAddress();
        
        // 0. student 테이블에 해당하는 Primary key 를 가지고 레코드가 존재하는지 확인 
        boolean isExistedStudent = studentRepository.existsById(studentNumber);
        if (!isExistedStudent) return 
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하지 않는 학생입니다.");

        // 1. student 클래스로 접근 (StudentRepository 사용)
        StudentEntity  studentEntity = studentRepository.
        // 2.dto.studentNumber 에 해당하는 인스턴스를 검색
        findById(studentNumber).get();
        // 3. 검색된 인스턴스의 address 값을 dto.address 로 변경
        studentEntity.setAddress(address);
        // 4. 변경한 인스턴스를 데이터베이스에 저장
        // repository.
        studentRepository.save(studentEntity);

        return ResponseEntity.status(HttpStatus.OK).body("성공!");
    }

    @Override 
    public ResponseEntity<String> deleteStudent(Integer studentNumber) {
        
        studentRepository.deleteById(studentNumber);

        return ResponseEntity.status(HttpStatus.OK).body("성공");
    }
}


//todo\\ JAVA -> App.java 함께 보며 java - spring 공부해보기



// 1. student  테이블로 접근
// 2.dto.studentNumber 에 해당하는 레코드를 검색
// 3. 검색된 레코드의 address 값을 dto.address 로 변경

// <<<<<<<<< ORM 으로 변경 >>>>>>>>>
// ------객체지향프로그래밍언어의 클래스 == RDBMS 의 테이블 ------
// ------객체지향프로그래밍언어의 인스턴스 == RDBMS 의 레코드 ------


// 1. student 클래스로 접근
// 2.dto.studentNumber 에 해당하는 인스턴스를 검색
// 3. 검색된 인스턴스의 address 값을 dto.address 로 변경