package com.sangin.basic.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// Request Body 로 받는 데이터에 대한 유효성 검사를 validation 의존성을 추가 해야함
public class SampleDTO {
//! private : 캡슐화_ 외부접근에서 X
     // 해당 속성을 null이 올 수 없도록 지정
    @NotNull 
    private String notNull;

    // 문자열일 경우 null 또는 빈 문자열이 올 수 없도록 지정
    @NotEmpty 
    private String notEmpty;

     // 문자열일 경우 null 또는 빈 문자열 또는 공백으로된 문자열이 올 수 없도록 지정
    @NotBlank
    private String notBlank;

    // RequestBody 로 받아오는 데이터는 Wrapper 클래스 타입으로 데이터를 받는 것이 좋음
    @NotNull 
    //todo/ 유효하지 않은 검증!! => @NotEmpty @NotBlank : 문자열에서만 유효함
    private Integer requiredInt;  // int -> Integer : int 는 null 을 받을 수 없어 인식하지 못해서, Integer 로 변경하였다

    // 문자열일 경우 문자열 길이의 최소 최대를 지정 (null 값이면 검사 안 함)
    @Length(min=5, max=10) 
    @NotNull
    private String length;

    // 최댓값과 최솟값 지정  : 값만 지정할 때 사용
    @Max(100) 
    @Min(0) 
    @NotNull //! @NotNull 을 넣어야만 검사가 유효해진다!
    private Integer maxMin;

    // 최대, 최소 범위 지정  : 범위를 지정할 때 사용
    @Range(min=0, max=100)
    @NotNull
    private Integer range;
    
    // 문자열이 이메일 형식인지 확인 / @의 유무만 검사를 한다
    @Email 
    @NotEmpty
    private String email;
    
    // 정규식을 이용해 문자열의 패턴 검사를 진행 
    // 사용예시) _ 전화번호 / 이메일 / url / 주민등록번호 / 비밀번호 / (영어,한글,숫자) 각각의 것으로만 된 문자열
    // >>> 정규식? [산대특]AWS > springboot > controller > 정규식 : 정리 확인
    //? EX) email@email.com / email@email.co.kr : 정규식으로 검사
    @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
//!                                        * : 갯수 무한정 | ? : or 개념                        . co       kr
    private String emailPattern;
}
