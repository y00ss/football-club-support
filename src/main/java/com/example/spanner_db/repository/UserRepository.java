package com.example.spanner_db.repository;

import com.example.spanner_db.entity.User;
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import com.google.cloud.spring.data.spanner.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository  extends SpannerRepository<User, Integer> {


    @Query("SELECT * FROM users u WHERE u.id = $1")
    User findByQueryUserById(@Param("p1") int idUser);


    @Transactional
    @Query("DELETE FROM users  WHERE id = $1")
    void deleteByQuery(@Param("p1") int idUser);

    void deleteById(int id);

    void deleteUsersById(@Param("p1") int idUser);


}
