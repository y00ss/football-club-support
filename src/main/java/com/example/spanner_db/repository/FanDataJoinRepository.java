package com.example.spanner_db.repository;

import com.example.spanner_db.dto.FanData;
import com.example.spanner_db.entity.Fan;
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import com.google.cloud.spring.data.spanner.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FanDataJoinRepository extends SpannerRepository<FanData, Long> {

    @Query(value = "SELECT u.name AS name, u.surname AS surname, t.team_name as team FROM fan f JOIN users u ON u.id = f.user_id JOIN teams t ON t.id = f.team_id WHERE t.id = $1" )
    List<FanData> findByQuery(@Param("p1") long id);

    @Query(value = "SELECT u.name AS name, u.surname AS surname, t.team_name as team FROM fan f JOIN users u ON u.id = f.user_id JOIN teams t ON t.id = f.team_id WHERE u.city = $1" )
    List<FanData> findByQueryFansByCityUser(@Param("p1") String cityName);

    @Query(value = "SELECT f.user_id AS id, u.name AS name, u.surname AS surname, t.team_name as team FROM fan f JOIN users u ON u.id = f.user_id JOIN teams t ON t.id = f.team_id" )
    List<FanData> findByQueryAll();
}
