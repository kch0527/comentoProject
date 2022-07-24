package com.comento.comentoproject;

import com.comento.comentoproject.entity.Board;
import com.comento.comentoproject.repository.BoardRepository;
import com.comento.comentoproject.requset.BoardPage;
import com.comento.comentoproject.response.BoardResponse;
import com.comento.comentoproject.service.BoardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class BoardServiceTest {
    @Autowired
    private BoardServiceImpl boardService;
    @Autowired
    private BoardRepository repository;

    @BeforeEach
    void clear(){
        repository.deleteAll();
    }


    @Test
    @DisplayName("1페이지 조회")
    void test3() {

        List<Board> boardList = IntStream.range(0, 30)
                .mapToObj(i -> {
                    return Board.builder()
                            .title("타이틀 : " + i)
                            .content("내용 : " + i)
                            .build();
                })
                .collect(Collectors.toList());
        repository.saveAll(boardList);

        BoardPage boardPage = BoardPage.builder()
                .page(1)
                .build();

        List<BoardResponse> list = boardService.getList(boardPage);

        assertEquals(5L, list.size());
        assertEquals("타이틀 : 29", list.get(0).getTitle());
    }

}
