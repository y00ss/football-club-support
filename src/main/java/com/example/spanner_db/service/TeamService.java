package com.example.spanner_db.service;

import com.example.spanner_db.entity.Team;
import com.example.spanner_db.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {


    @Autowired
    TeamRepository teamRepository;

    public List<Team> getAllTeams(){
        return (List<Team>) teamRepository.findAll();
    }


    public List<Team> getTeamByCity(String city){
        return teamRepository.findByCity(city);
    }

    public  Team getTeamById(long id){
        return teamRepository.findTeamById(id);
    }


    public Team getTeamByName(String name){
        return teamRepository.findTeamByName(name);
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }
}
