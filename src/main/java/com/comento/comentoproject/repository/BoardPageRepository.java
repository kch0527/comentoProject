package com.comento.comentoproject.repository;

import com.comento.comentoproject.entity.Board;
import com.comento.comentoproject.requset.BoardPage;

import java.util.List;

public interface BoardPageRepository {

    List<Board> getList(BoardPage boardPage);
}
