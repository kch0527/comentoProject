package com.comento.comentoproject.controller;


import com.comento.comentoproject.requset.BoardCreate;
import com.comento.comentoproject.requset.BoardEdit;
import com.comento.comentoproject.requset.BoardPage;
import com.comento.comentoproject.response.BoardResponse;
import com.comento.comentoproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public String getList(@ModelAttribute BoardPage boardPage, Model model){
        System.out.println("getPage : "+boardPage.getPage());
        System.out.println("getSize : "+boardPage.getSize());
        System.out.println("getOffset : "+boardPage.getOffset());
        List<BoardResponse> list = boardService.getList(boardPage);
        model.addAttribute("boards", list);
        return "board/list";
    }

    @PostMapping("/boards")
    public String postBoard(@Valid BoardCreate boardCreate){
        boardService.saveBoard(boardCreate);
        return "board/create";
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

    @PutMapping("/boards/edit/{boardId}")
    public String editBoard(@PathVariable Long boardId, @Valid BoardEdit boardEdit){
        boardService.editBoard(boardId, boardEdit);
        return "board/read";
    }

    @DeleteMapping("/boards/{boardId}")
    public String deleteBoard(@PathVariable Long boardId){
        boardService.deleteBoard(boardId);
        return "board/list";
    }

}
