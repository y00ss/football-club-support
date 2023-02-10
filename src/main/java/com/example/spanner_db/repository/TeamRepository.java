package com.example.spanner_db.repository;

import com.example.spanner_db.entity.Team;
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import com.google.cloud.spring.data.spanner.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TeamRepository extends SpannerRepository<Team, Integer> {

    List<Team> findByCity(String city);

    @Query("SELECT * FROM teams t WHERE t.id = $1")
    Team findTeamById(@Param("p1") long id);

    @Query("SELECT * FROM teams t WHERE t.team_name = $1")
    Team findTeamByName(@Param("p1") String name);
}
