package com.comento.comentoproject.requset;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardPage {

    private static final int MAX_SIZE = 1000;
    @Builder.Default
    private Integer page = 1;
    @Builder.Default
    private Integer size = 5;

    public long getOffset(){
        return (long) (Math.max(1, page) - 1) * Math.min(size, MAX_SIZE);
    }
}
