package com.example.assignmentsevlet.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PlayerIndex {
    private Long id;
    private Long playerId;

    private Long indexId;
    private Float value;
}
