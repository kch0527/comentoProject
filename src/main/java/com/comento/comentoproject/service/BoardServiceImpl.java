package com.comento.comentoproject.service;

import com.comento.comentoproject.entity.Board;
import com.comento.comentoproject.entity.BoardEditor;
import com.comento.comentoproject.exception.BoardNotFound;
import com.comento.comentoproject.repository.BoardRepository;
import com.comento.comentoproject.requset.BoardCreate;
import com.comento.comentoproject.requset.BoardEdit;

import com.comento.comentoproject.response.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Transactional
    public void saveBoard(BoardCreate boardCreate){
        Board board = Board.builder()
                .title(boardCreate.getTitle())
                .content(boardCreate.getContent())
                .build();
        boardRepository.save(board);
    }

    public BoardResponse getBoard(Long boardId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(BoardNotFound::new);

        BoardResponse boardResponse = BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .modDate(board.getModDate())
                .regDate(board.getRegDate())
                .build();

        return boardResponse;
    }

    public Page<BoardResponse> getList(Pageable pageable){
        return boardRepository.findAll(pageable).map(BoardResponse::new);
    }

    @Transactional
    public void editBoard(Long boardId, BoardEdit boardEdit){
        Board board = boardRepository.findById(boardId).orElseThrow(BoardNotFound::new);

        BoardEditor.BoardEditorBuilder boardEditorBuilder = board.toEditor();

        BoardEditor boardEditor = boardEditorBuilder.title(boardEdit.getTitle())
                .content(boardEdit.getContent())
                .build();

        board.edit(boardEditor);
    }

    @Transactional
    public void deleteBoard(Long boardId){
        boardRepository.delete(boardRepository.findById(boardId).orElseThrow(BoardNotFound::new));
    }

}
