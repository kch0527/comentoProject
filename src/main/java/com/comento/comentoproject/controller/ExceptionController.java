package com.comento.comentoproject.controller;

import com.comento.comentoproject.exception.TopException;
import com.comento.comentoproject.response.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(TopException.class)
    public ErrorResponse topException(TopException e){

        ErrorResponse response = ErrorResponse.builder()
                .message(e.getMessage())
                .build();

        return response;
    }
}
