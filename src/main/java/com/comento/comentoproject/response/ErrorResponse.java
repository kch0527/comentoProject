package com.comento.comentoproject.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private final String message;

    @Builder
    public ErrorResponse(String message) {
        this.message = message;
    }
}
