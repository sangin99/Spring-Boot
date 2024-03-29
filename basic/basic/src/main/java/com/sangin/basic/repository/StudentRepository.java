package com.sangin.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sangin.basic.entity.StudentEntity;
import java.util.List;


// Repository 레이어
// - 데이터베이스와 관련된 작업들을 처리하는 영역
// - Service 가 비즈니스 로직 수행 중 데이터베이스 작업이 필요할 때 Repository 를 거쳐서 데이터베이스 작업을 수행

// @Repository : 해당 클래스를 Spring Bean 으로 등록하는 어노테이션 = @Component 와 동일
// - interface 에 @Repository 를 사용한 이유?
// > JPA 를 사용하면 JpaRepository 인터페이스를 상속받은 인터페이스의 구현체를 JPA 가 자동으로 생성
@Repository
public interface StudentRepository  
// JpaRepository <T, ID> :
// - JPA 기반의 Repository 를 구현하는 주요 인터페이스
// - 기본 CRUD, 정렬 기능을 제공하고 있음
// - JPA 기반 Repository 를 생성할 때 반드시 상속해야함
// - 1) 매개타입 T : 해당 Repository 가 어떤 Entity 의 Repository 인지 나타내는 매개타입
// - 2) 메개타입 ID : 해당 Repository 에서 사용하는 Entity 의 Primary key 데이터 타입을 지정하는 매개타입
extends JpaRepository<StudentEntity, Integer> {
    //  Student 테이블에서 address 가 '서울특별시'인 레코드 조회

    // SQL : 
    //   SELECT * FROM Student
    //   WHERE address = '서울특별시';
// find(SELECT *)ByAddress(WHERE address)
    List<StudentEntity> findByAddress(String address);
//?=========================================================================================== 
    // SQL :
    //      SELECT * FROM student
    //      WHERE graduation IS true
    //      ORDER BY age DESC;
// find ByGraduation OrderByAgeDesc
    List<StudentEntity> findByGraduationOrderByAgeDesc(Boolean graduation);
//?============================================================================================
    // SQL : 
    //      SELECT * FROM student
    //      WHERE student_number = 5
    //      AND age > 20;
// find By StudentNumber And AgeGreaterThen
    StudentEntity findByStudentNumberAndAgeGreaterThan(Integer studentNumber, Integer age);
    //! 출력 예상이 0~1 개 일 때는 List 사용 X
//?============================================================================================
    // SQL : 
    //      SELECT count(*) FROM student
    //      WHERE graduation IS false
    int countByGraduation(Boolean graduation);
//?============================================================================================
    // Q. address 가 '서울특별시' 이면서 graduation 이 true 인 레코드가 존재하는가?
    // A. 존재하는지 아닌지를 알고 싶은 것이다 (true / false) -> boolean 사용
    boolean existsByAddressAndGraduation(String address, Boolean graduation);
}