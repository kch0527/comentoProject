package com.comento.comentoproject.controller;


import com.comento.comentoproject.requset.BoardCreate;
import com.comento.comentoproject.requset.BoardEdit;

import com.comento.comentoproject.response.BoardResponse;
import com.comento.comentoproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public String getList(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)
                              Pageable pageable, Model model){

        Page<BoardResponse> list = boardService.getList(pageable);

        model.addAttribute("boards", list);
        return "board/list";
    }

    @GetMapping("/boards/create")
    public String createBoardForm(){
        return "board/create";
    }

    @PostMapping("/boards")
    public String createBoard(@Valid BoardCreate boardCreate){
        boardService.saveBoard(boardCreate);
        return "redirect:/boards";
    }

    @GetMapping("/boards/{boardId}")
    public String getBoard(@PathVariable Long boardId, Model model){
        model.addAttribute("board", boardService.getBoard(boardId));
        return "board/read";
    }

    @GetMapping("/boards/edit/{boardId}")
    public String editBoardForm(@PathVariable Long boardId, Model model){
        model.addAttribute("board", boardService.getBoard(boardId));
        return "board/edit";
    }

    @PutMapping("/boards/{boardId}")
    public String editBoard(@PathVariable Long boardId, @Valid BoardEdit boardEdit){
        boardService.editBoard(boardId, boardEdit);
        return "redirect:/boards/" + boardId;
    }

    @DeleteMapping("/boards/{boardId}")
    public String deleteBoard(@PathVariable Long boardId){
        boardService.deleteBoard(boardId);
        return "redirect:/boards";
    }

}
