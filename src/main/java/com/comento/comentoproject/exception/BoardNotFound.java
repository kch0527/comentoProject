package com.comento.comentoproject.exception;

public class BoardNotFound extends TopException{

    private static final String MESSAGE = "없는 게시물";
    public BoardNotFound() {
        super(MESSAGE);
    }


}
