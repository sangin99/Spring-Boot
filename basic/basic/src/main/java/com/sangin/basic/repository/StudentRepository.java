package com.sangin.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    StudentEntity findByStudentNumberAndAgeGreaterThan (Integer studentNumber, Integer age);
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
//*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    // SELECT * FROM
    // WHERE 
    // (student_number = ? OR address = ?) AND (graduation = ?)
    //! 이정도의 복잡한 식은 쿼리메서드 생성에 한계가 있다...
    //! 그래서! 그걸 지원해주는게 `@Query` 이다 

    // @Query :
    // - 쿼리 메서드 생성 방식만으로는 실제 SQL 을 작성하는데 한계가 있음
    //   ex) 복잡한 쿼리 , 조인 , 서브 쿼리 , 그룹화를 사용할 수 없음
    // - 직접 SQL문으로 쿼리를 생성하도록 하는 어느테이션

// 예시)
//   SELECT * FROM student
//   WHERE student_number = 5
//   AND age > 20;

    // 1. JPQL (Java Persistence Query Language)
    // - 표준 SQL과 매우 흡사하지만 Entity명과 Entity속성으로 쿼리를 작성하는 방법
    @Query (value =
        "SELECT s FROM student s WHERE s.studentNumber = ?1 AND s.age > ?2",   // student , student_number : 테이블명 자리에 JPQL 에서는 Entity명이 와야한다 / * 자리에 가져올 객체의 속성을 적는다
        nativeQuery=false
    )
    List<StudentEntity> getStudent2(Integer studentNumber, Integer age);

    // 2. Native SQL :
    // - 현재 사용하고 있는 RDBMS의 SQL문법을 그대로 따르는 방식   
    @Query (
        // value="SELECT * FROM student WHERE student_number = ?1 AND age > ?2" ,   //! . ?1 : 첫번째 매개변수에 넣겠다(studentNumber) / ?2 : 두번째 매개변수에 넣겠다 (age)
        value = 
        "SELECT " +
            "student_number AS studentNumber, " +
            "name, " +
            "age, " +
            "address, " +
            "graduation, " +
        "FROM student " +
        "WHERE student_number = ?1 " +
        "AND age > ?2 " ,
        nativeQuery=true
    )
    List<StudentEntity> getStudent(Integer studentNumber, Integer age);

    //! Q. student_number 와 studentNumber 가 다르다
    //! A. SQL문 value에 as 를 사용한다 / 연결되는데에 있어 띄어쓰기 ※주의※


    //todo > 다른 예시 
    @Query (
        // value="SELECT * FROM student WHERE student_number = ?1 AND age > ?2" ,   //! . ?1 : 첫번째 매개변수에 넣겠다(studentNumber) / ?2 : 두번째 매개변수에 넣겠다 (age)
        value = 
        "SELECT " +
            "student_number AS studentNumber, " +
            "name, " +
            "age, " +
            "address, " +
            "graduation, " +
        "FROM student " +
        "WHERE student_number = :student_number " +
        "AND age > :age " ,
        nativeQuery=true
    )
    List<StudentEntity> getStudent3(
        @Param("student_number") Integer studentNumber, 
        @Param("age") Integer age
        // @Param : student_number , age 값을 studentNumber , age 에 넣겠다
    );

}