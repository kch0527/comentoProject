package com.comento.comentoproject.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ConnectionTestEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Builder
    public ConnectionTestEntity(String name) {
        this.name = name;
    }
}
