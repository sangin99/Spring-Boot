package com.sangin.basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sangin.basic.dto.request.student.PatchStudentRequestDto;
import com.sangin.basic.dto.request.student.PostStudentRequestDto;
import com.sangin.basic.dto.request.student.SignInRequestDto;
import com.sangin.basic.entity.StudentEntity;
import com.sangin.basic.repository.StudentRepository;
import com.sangin.basic.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service // 서비스 형태의 spring bean 으로 등록하기
@RequiredArgsConstructor
public class StudentServiceImplement implements StudentService {

    private final StudentRepository studentRepository;

    // PasswordEncoder 인터페이스 : 
    // - Spring Security 에서 제공해주는 비밀번호흫 안전하게 관리하고 검증하도록 도움을 주는 인터페이스
    // 제공하는 메서드
    // - String encode(평문패스워드) : 평문 패스워드를 암호화해서 반환함
    // - boolean matches(평문패스워드, 암호와된패스워드) : 평문 패스워드와 암호화된 패스워드가 같은지 비교 결과를 반환
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<String> postStudent(PostStudentRequestDto dto) {
        
//          StudentEntity studentEntity = new StudentEntity();   // 인스턴스 만들기
//          studentEntity.setName(dto.getName());
//          studentEntity.setAge(dto.getAge());
//          studentEntity.setAddress(dto.getAddress());
//          studentEntity.setGraduation(dto.getGraduation());

        // 패스워드 암호화 작업
        String password = dto.getPassword();
        String encodedPassword = passwordEncoder.encode(password);

        dto.setPassword(encodedPassword);

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

    @Override
    public ResponseEntity<String> signIn(SignInRequestDto dto) {
       
        try {

            Integer studentNumber = dto.getStudentNumber();
            StudentEntity studentEntity = studentRepository.findByStudentNumber(studentNumber);

            if (studentEntity == null)
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("오류");

            // 사용자가 입력한 패스워드와 암호화된 패스워드가 매치되는지 확인
            String password = dto.getPassword();
            String encodedPassword = studentEntity.getPassword();

            boolean isEqualPassword = passwordEncoder.matches(password, encodedPassword);  // 데이터베이스에 있는 것은 암호화 되어있어 비교가 불가하기에 .matches 를 사용한다
            if (!isEqualPassword)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("비밀번호 불일치");

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("오류");
        }

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