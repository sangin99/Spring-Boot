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
@Entity(name="comment")
@Table(name="comment")
public class CommentEntity {
    @Id
    private Integer comment_number;
    private Integer board_number;
    private String user_email;
    private String contents;
    private String write_datetime;
}