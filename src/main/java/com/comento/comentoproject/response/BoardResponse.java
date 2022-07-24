package com.comento.comentoproject.response;

import com.comento.comentoproject.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponse {

    private final Long id;
    private final String title;
    private final String content;

    public BoardResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }

    @Builder
    public BoardResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
