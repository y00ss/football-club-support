package com.example.spanner_db.service;

import com.example.spanner_db.dto.UserRegister;
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
import java.util.UUID;

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


    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    public User getUser(String p1) {

        return userRepository.findByQueryUserById((p1));
    }

    public User saveUser(UserRegister user) {

        User newUser = new User();
        Fan fan = new Fan();

        // Data user
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setCity(user.getCity());
        newUser.setBirth(user.getBirth());

        // Data fan
        fan.setUser_id(newUser.getId());
        fan.setTeam_id(user.getTeamId());
        fan.setSubscriber(user.isSubscriber());

        userRepository.save(newUser);
        fanService.saveFan(fan);


        return newUser;

    }

    public void deleteUser(String idUser, String nameTeam) {


        Team team = teamService.getTeamByName(nameTeam);


        deleteFanByUserId(idUser, team.getId());
        deleteUserById(idUser);

        /*System.out.println(idUser);
        fanRepository.deleteByQuery((long) idUser);
        userRepository.deleteUsersById(Integer.parseInt(id));*/
    }

    @Transactional
    public void deleteUserById(String idUser) {
        Key key = Key.newBuilder().append(idUser).build();
        spannerTemplate.delete(User.class, key);
    }

    @Transactional
    void deleteFanByUserId(String userId, int idTeam) {

        Key key = Key.newBuilder()
                .append(userId)
                .append(idTeam)
                .build();

        spannerTemplate.delete(Fan.class, key);
    }


}
