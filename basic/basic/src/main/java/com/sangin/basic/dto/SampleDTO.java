package com.sangin.basic.dto;

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
public class SampleDTO {
//! private : 캡슐화_ 외부접근에서 X
    private String userId;
    private String userPassword;
}
