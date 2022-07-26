package com.comento.comentoproject.repository;

import com.comento.comentoproject.entity.Board;
import com.comento.comentoproject.requset.BoardPage;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.comento.comentoproject.entity.QBoard.board;

@RequiredArgsConstructor
public class BoardPageRepositoryImpl implements BoardPageRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Board> getList(BoardPage boardPage, Pageable pageable) {
        JPAQuery<Board> query = jpaQueryFactory.selectFrom(board)
                .offset(boardPage.getOffset())
                .limit(boardPage.getSize())
                .orderBy(board.id.desc());
        List<Board> results = query.fetch();
        return new PageImpl<>(results, pageable, results.size());

    }
}
