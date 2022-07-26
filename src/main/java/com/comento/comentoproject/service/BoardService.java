package com.comento.comentoproject.service;

import com.comento.comentoproject.requset.BoardCreate;
import com.comento.comentoproject.requset.BoardEdit;

import com.comento.comentoproject.response.BoardResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface BoardService {

    void saveBoard(BoardCreate boardCreate);
    BoardResponse getBoard(Long boardId);
    Page<BoardResponse> getList(Pageable pageable);
    void editBoard(Long boardId, BoardEdit boardEdit);
    void deleteBoard(Long boardId);
}
