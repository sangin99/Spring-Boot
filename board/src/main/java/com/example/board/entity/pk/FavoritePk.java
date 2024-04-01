package com.example.board.entity.pk;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavoritePk implements Serializable {
    @Column(name="board_number")
    private Integer boardNumber;
    @Column(name="user_email")
    private String userEmail;

}

// FavoritePk 클래스를 entity 의 
