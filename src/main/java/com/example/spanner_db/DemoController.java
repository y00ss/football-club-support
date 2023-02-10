package com.example.spanner_db;

import com.example.spanner_db.entity.User;
import com.example.spanner_db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

public class DemoController {

/*
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name){
        employeeRepository.save(new Employee(
                UUID.randomUUID().toString(),
                name
        ));
        return "Hello "+name;
    }
*/
/*
    @Autowired
    UserRepository repository;

    @GetMapping("/{name}")
    public String hello(@PathVariable String name) {
        repository.save(new User
                (
                        name, "Rest", LocalDate.now(), "Ivrea"
                ));

        return "Hello " + name;
    }

    @GetMapping("/tifosi")
    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }


    @GetMapping("/tifosi/{team}")
    public List<User> getAllFansByTeam(@PathVariable String team){
        return repository.findAllFansByTeam(team);
    }*/
}
