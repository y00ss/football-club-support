package com.example.spanner_db.repository;

import com.example.spanner_db.entity.User;

import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import com.google.cloud.spring.data.spanner.repository.query.Query;
import org.springframework.data.repository.query.Param;


public interface TestRepo extends SpannerRepository<User, Long> {
    @Query(value = "SELECT * FROM users u WHERE u.name = @p1")
    User findByValue(@Param("p1") String value);
}
