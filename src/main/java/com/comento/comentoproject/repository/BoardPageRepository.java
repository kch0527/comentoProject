package com.comento.comentoproject.repository;

import com.comento.comentoproject.entity.Board;
import com.comento.comentoproject.requset.BoardPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardPageRepository {

    Page<Board> getList(BoardPage boardPage, Pageable pageable);
}
