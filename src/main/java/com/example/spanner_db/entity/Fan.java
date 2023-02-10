package com.example.spanner_db.entity;

import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "fan")
@Data
@AllArgsConstructor
public class Fan {

    private int user_id;
    private int team_id;

    public Fan(){}
}
