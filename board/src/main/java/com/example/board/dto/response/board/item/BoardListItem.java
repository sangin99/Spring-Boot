package com.example.board.dto.response.board.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor  //완전 캡슐화로 작업하겠다는 의미
public class BoardListItem {
    private Integer boardNumber;
    private String title;
    private String content;
    private String boardTitleImage;
    private Integer favoriteCount;
    private Integer commentCount;
    private Integer viewCount;
    private String writeDatetime;
    private String writerNickname;
    private String writerProfileImage;
}
