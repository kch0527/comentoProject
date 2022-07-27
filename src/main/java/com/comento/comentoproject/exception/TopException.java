package com.comento.comentoproject.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class TopException extends RuntimeException{

    public TopException(String message) {
        super(message);
    }


}
