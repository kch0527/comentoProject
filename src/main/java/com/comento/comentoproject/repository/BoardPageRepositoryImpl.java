package com.comento.comentoproject.repository;

import com.comento.comentoproject.entity.Board;
import com.comento.comentoproject.requset.BoardPage;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.comento.comentoproject.entity.QBoard.board;

@RequiredArgsConstructor
public class BoardPageRepositoryImpl implements BoardPageRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Board> getList(BoardPage boardPage) {
        return jpaQueryFactory.selectFrom(board)
                .offset(boardPage.getOffset())
                .limit(boardPage.getSize())
                .orderBy(board.id.desc())
                .fetch();
    }
}
