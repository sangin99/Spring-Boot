package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.board.entity.Board_imageEntity;

@Repository
public interface Board_imageRepository extends JpaRepository<Board_imageEntity, Integer>{
    
}
