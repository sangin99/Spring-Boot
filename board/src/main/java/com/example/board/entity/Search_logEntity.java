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
@Entity(name="search_log")
@Table(name="search_log")
public class Search_logEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer log_sequence;
    private String search_word;
    private String relation_word;
    private String relation;
}