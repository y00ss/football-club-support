package com.example.spanner_db.controller;

import com.example.spanner_db.entity.User;
import com.example.spanner_db.repository.TestRepo;
import com.example.spanner_db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    TestRepo testRepo;

    @GetMapping()
    private List<User> getAllUsers(){
        //torna iterable cast list
        return userService.getAllUser();
    }

    // todo fai la dao
    @PostMapping
    private User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{name}")
    private User getByName(@PathVariable("name") String id){
        return  userService.getUser(id);
    }

    @PostMapping("/delete")
    public User deleteUser(@RequestParam("id_user") String idUser, @RequestParam("id_team") String nameTeam) {
        User user = userService.getUser(idUser);
        if (user != null) {
            userService.deleteUser(idUser, nameTeam);
            return user;
        }
        return null;
    }
}
