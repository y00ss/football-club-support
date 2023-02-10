package com.example.spanner_db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.cloud.spring.data.spanner.core.mapping.Column;
import com.google.cloud.spring.data.spanner.core.mapping.NotMapped;
import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;


@Table(name = "users")
@Data
@AllArgsConstructor
public class User {

    @PrimaryKey
    @Column(name = "id")
    private int id;

    private String name, surname;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
    @Column(name="date_of_birth")
    private LocalDate birth;

    private String city;

    @NotMapped
    private String teamId;

    public User(String name, String surname, LocalDate birth, String city, String teamId) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.city = city;
        this.teamId = teamId;
    }

    public User(){}
}
