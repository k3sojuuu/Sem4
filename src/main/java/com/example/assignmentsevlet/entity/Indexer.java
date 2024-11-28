package com.example.assignmentsevlet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Indexer {
    private Long indexId;
    private String name;
    private Float valueMin;
    private Float valueMax;

}