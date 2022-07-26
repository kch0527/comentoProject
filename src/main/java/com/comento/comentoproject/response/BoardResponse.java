package com.comento.comentoproject.response;

import com.comento.comentoproject.entity.Board;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
public class BoardResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String modDate;
    private final String regDate;

    public BoardResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.modDate = board.getModDate();
        this.regDate = board.getRegDate();
    }

    @Builder
    public BoardResponse(Long id, String title, String content, String modDate, String regDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.modDate = modDate;
        this.regDate = regDate;
    }
}
