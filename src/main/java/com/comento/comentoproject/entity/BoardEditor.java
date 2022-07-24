package com.comento.comentoproject.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardEditor {
    private String title;
    private String content;

    @Builder
    public BoardEditor(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
