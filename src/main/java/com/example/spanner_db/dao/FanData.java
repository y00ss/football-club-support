package com.example.spanner_db.dao;

import lombok.Data;

@Data
public class FanData {

    private String id;

    private String name;
    private String surname;

    private String team;

    public FanData(String id, String name, String surname, String team) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.team = team;
    }


}
