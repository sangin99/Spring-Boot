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
@Entity(name="search_log")
@Table(name="search_log")
public class Search_logEntity {
    @Id
    private Integer log_sequence;
    private String search_word;
    private String relation_word;
    private String relation;
}