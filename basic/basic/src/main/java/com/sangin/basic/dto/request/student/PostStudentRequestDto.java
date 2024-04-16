package com.sangin.basic.dto.request.student;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostStudentRequestDto {
    // 필수값 / NULL x / 긴문자 x / 공백으로만 채워지는 것 x
    @NotBlank      
    private String name;
    
    // 반드시 출력 / int -> notnull X
    @NotNull   
    @Min(0)
    private Integer age;

    @NotBlank
    private String address;

    @NotNull
    private Boolean graduation;

    @NotBlank
    private String password;
}
