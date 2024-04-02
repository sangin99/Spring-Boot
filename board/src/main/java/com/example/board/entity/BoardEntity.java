package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

@Entity(name="board")
@Table(name="board")
public class BoardEntity {
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer board_number;
    private String title;
    private String contents;
    private Integer viewCount;
    private Integer commentCount;
    private Integer favoriteCount;
    private String writeDatetime;
    private String writeEmail;
}
