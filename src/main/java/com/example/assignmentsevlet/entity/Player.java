package com.example.assignmentsevlet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private Long playerId;
    private String name;
    private String fullName;
    private String age;
    private Long indexId;
}