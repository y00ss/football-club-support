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
import java.util.UUID;


@Table(name = "users")
@Data
public class User {


    @PrimaryKey
    @Column(name = "id")
    private String id;

    private String name, surname;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
    @Column(name="date_of_birth")
    private LocalDate birth;

    private String city;

    @NotMapped
    private String teamId;

    public User(String id,String name, String surname, LocalDate birth, String city, String teamId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.city = city;
        this.teamId = teamId;
    }

    public User(){
        this.id = UUID.randomUUID().toString();
    }
}
