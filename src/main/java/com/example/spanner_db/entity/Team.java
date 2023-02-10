package com.example.spanner_db.entity;

import com.google.cloud.spring.data.spanner.core.mapping.Column;
import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.Data;

@Table(name = "teams")
@Data
public class Team {

    @PrimaryKey
    private int id;

    @Column(name = "team_name")
    private String name;

    private String city;

    private String stadium;

    public Team() {
    }

    public Team(int id, String name, String city, String stadium) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.stadium = stadium;
    }
}

