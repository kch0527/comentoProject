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

    public BoardResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.modDate = board.getModDate();
    }

    @Builder
    public BoardResponse(Long id, String title, String content, String modDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.modDate = modDate;
    }
}
