package com.comento.comentoproject;

import com.comento.comentoproject.entity.Board;
import com.comento.comentoproject.repository.BoardRepository;
import com.comento.comentoproject.service.BoardServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
class ComentoProjectApplicationTests {

    @Autowired
    BoardRepository repository;

    @Test
    void testBoardInitial() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Board boardEntity = Board.builder()
                    .title("title" + i)
                    .content("content" + i)
                    .build();
            repository.save(boardEntity);
        });
    }

}
