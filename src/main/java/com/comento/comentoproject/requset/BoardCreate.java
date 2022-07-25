package com.comento.comentoproject.requset;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class BoardCreate {

    @NotBlank(message = "타이틀이 없음")
    private String title;

    @NotBlank(message = "컨텐츠가 없음")
    private String content;



    @Builder
    public BoardCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
