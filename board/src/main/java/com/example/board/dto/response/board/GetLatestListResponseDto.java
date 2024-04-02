package com.example.board.dto.response.board;

import java.util.List;

import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.board.item.BoardListItem;


import lombok.Getter;

@Getter
public class GetLatestListResponseDto extends ResponseDto {
    private List<BoardListItem> latestList;

    public GetLatestListResponseDto(
        String code, String message, List<BoardListItem> latestList) {
        super(code, message);
        this.latestList = latestList;
    }
}
