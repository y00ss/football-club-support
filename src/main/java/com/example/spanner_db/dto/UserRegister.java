package com.example.spanner_db.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class UserRegister {

    private String name, surname;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
    private LocalDate birth;

    private String city;

    private int teamId;

    private boolean subscriber;
}
