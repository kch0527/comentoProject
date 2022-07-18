package com.comento.comentoproject.connection;

import com.comento.comentoproject.entity.ConnectionTestEntity;
import com.comento.comentoproject.repository.ConnectionTestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DbTest {

    @Autowired
    private ConnectionTestRepository repository;

    @BeforeEach
    void clear(){
        repository.deleteAll();
    }

    @Test
    @DisplayName("DB 연동 테스트")
    void test(){
        ConnectionTestEntity entity = ConnectionTestEntity.builder()
                .name("김찬회")
                .build();

        repository.save(entity);

        assertEquals(1L, repository.count());
        ConnectionTestEntity entity1 = repository.findAll().get(0);
        assertEquals("김찬회", entity1.getName());
    }

}
