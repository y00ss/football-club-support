package com.example.spanner_db.repository;

import com.example.spanner_db.entity.Fan;
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import com.google.cloud.spring.data.spanner.repository.query.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

public interface FanRepository extends SpannerRepository<Fan, Long> {



    @Modifying
    @Query("DELETE FROM fan  WHERE user_id = $1")
    void deleteByQuery(@Param("p1") long idFan);

/*  void deleteFanByUserId(long idUser);

    void deleteFanByUser_id(long id);*/
}
