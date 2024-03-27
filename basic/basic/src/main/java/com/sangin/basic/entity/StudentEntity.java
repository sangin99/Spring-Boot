package com.sangin.basic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter //학업을 위해 추가로 넣은 @(어노테이션)
@NoArgsConstructor //학업을 위해 추가로 넣은 @(어노테이션)

// Entity : RDBMS 의 테이블과 매핑되는 클래스
// - 웹 애플리케이션 서버와 데이터베이스 서버간의 데이터 관리를 위한 객체

@Getter
@AllArgsConstructor

// @Entity : 
// - 해당 클래스를 Entity 클래스로 등록하는 어노테이션
// - JPA 에서 데이터 관리를 위한 주된 객체
// - name 속성 : Entity 클래스의 이름을 지정    
@Entity(name="student")  // Java 클래스를 JPA Entity로 표시하여 해당 클래스를 데이터베이스의 테이블과 매핑할 수 있게한다
// @Table : 
// - 해당 Entity 클래스를 RDBMS 의 어떤 테이블과 매핑할지 지정하는 어노테이션
// - name 속성 : 매핑할 RDBMS 의 테이블명을 지정
// - 만약, 클래스명 - Entity 명 - Table 명이 동일하면 생략 가능
@Table(name="student")  // JPA Entity 클래스와 데이터베이스 테이블간의 매핑을 설정하거나 수정할 때 사용 //? name=데이터베이스 테이블명 
public class StudentEntity {
    // @Id : 
    // - Entity 의 필드 중 Primary Key 로 사용되는 필드를 지정
    @Id
    // @GeneratedValue
    //  - Primary key 의 자동 생성 전략을 지정
    //  - AUTO : JPA 가 적절한 생성 전략을 선택
    // - IDENTITY : auto_increment  전략
    // - SEQUENCE : 데이터베이스 sequence 전략
    // - TABLE : 키 생성 테이블 전략
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column : 
    // - 해딩 필드를 매핑할 테이블의 어떤 컬럼과 매핑할지 지정
    // - name 속성 : 실제 컬럼의 이름
    // - nullable 속성 : null 포함 가능 여부
    // - unqiue 속성 : unqiue 제약 여부
    // - length 속성 : 컬럼의 길이
    // - 만약, 테이블의 컬럼명과 클래스의 필드명이 같으면 생략 가능
    @Column(name = "student_number", nullable=false, unique=true, insertable=false, updatable=false, length=10)
    private Integer studentNumber;
    
    private String name;
    private Integer age;
    private String address;  
    private Boolean graduation;
}