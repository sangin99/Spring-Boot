package com.sangin.basic.dto.request.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
// 초기화 하기
@Setter
@NoArgsConstructor
public class PatchStudentRequestDto {
    @NotNull // 유효성 검사
    private Integer studentNumber;
    @NotBlank
    private String address;
}

