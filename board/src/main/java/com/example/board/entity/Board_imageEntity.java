package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

@Entity(name="board_image")
@Table(name="board_image")
public class Board_imageEntity {
    @Id
    private Integer sequence;
    private Integer board_number;
    private String image_url;
}
