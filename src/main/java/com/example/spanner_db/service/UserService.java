package com.example.spanner_db.service;

import com.example.spanner_db.entity.Fan;
import com.example.spanner_db.entity.Team;
import com.example.spanner_db.entity.User;
import com.example.spanner_db.repository.FanRepository;
import com.example.spanner_db.repository.UserRepository;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.cloud.spring.data.spanner.core.SpannerQueryOptions;
import com.google.cloud.spring.data.spanner.core.SpannerTemplate;

import java.util.List;

@Component
@Service
public class UserService {

    @Autowired
     UserRepository userRepository;

    @Autowired
    FanRepository fanRepository;

    @Autowired
     FanService fanService;


    @Autowired
    TeamService teamService;

    @Autowired
    SpannerTemplate spannerTemplate;


    public List<User> getAllUser(){
        return (List<User>) userRepository.findAll();
    }

    public User getUser(String p1){

        return userRepository.findByQueryUserById(Integer.parseInt(p1));
    }

    public User saveUser(User user){

        Fan fan = new Fan();

        int idUser = getAllUser().size() + 1;


        //user.setId(UUID.randomUUID());

        user.setId(idUser);

        fan.setUser_id(idUser);
        fan.setTeam_id(Integer.parseInt(user.getTeamId()));

        user = userRepository.save(user);

        fan = fanService.saveFan(fan);

        return user;

    }

    public void deleteUser(String idUser, String nameTeam){


        Team team = teamService.getTeamByName(nameTeam);
        int user = Integer.parseInt(idUser);

        deleteFanByUserId(user, team.getId());
        deleteUserById(user);

        /*System.out.println(idUser);
        fanRepository.deleteByQuery((long) idUser);
        userRepository.deleteUsersById(Integer.parseInt(id));*/
    }

    @Transactional
    public void deleteUserById(int idUser) {
        Key key = Key.newBuilder().append(idUser).build();
        spannerTemplate.delete(User.class, key);
    }

    @Transactional
    public void deleteFanByUserId(long userId, long teamId) {
        Key key = Key.newBuilder().append(userId).append(teamId).build();
        spannerTemplate.delete(Fan.class, key);
    }


}
