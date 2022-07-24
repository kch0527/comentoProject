package com.comento.comentoproject.service;

import com.comento.comentoproject.requset.BoardCreate;
import com.comento.comentoproject.requset.BoardEdit;
import com.comento.comentoproject.requset.BoardPage;
import com.comento.comentoproject.response.BoardResponse;

import java.util.List;

public interface BoardService {

    void saveBoard(BoardCreate boardCreate);
    BoardResponse getBoard(Long boardId);
    List<BoardResponse> getList(BoardPage boardPage);
    void editBoard(Long boardId, BoardEdit boardEdit);
    void deleteBoard(Long boardId);
}
