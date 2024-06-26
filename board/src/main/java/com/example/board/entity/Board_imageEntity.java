package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name="board_image")
@Table(name="board_image")
public class Board_imageEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer sequence;
    private Integer board_number;
    private String image_url;
}
