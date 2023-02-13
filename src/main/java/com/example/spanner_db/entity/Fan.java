package com.example.spanner_db.entity;

import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "fans")
@Data
@AllArgsConstructor
public class Fan {

    private String user_id;
    private int team_id;

    private boolean subscriber;

    public Fan(){}
}
