package com.example.spanner_db.controller;

import com.example.spanner_db.entity.Team;
import com.example.spanner_db.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping()
    private List<Team> getAllTeam(){
        return teamService.getAllTeams();
    }

    @GetMapping("/{teamId}")
    private Team getTeamById(@PathVariable(name = "teamId") String teamId){
        int id = Integer.parseInt(teamId);
        return teamService.getTeamById(id);
    }

    @PostMapping()
    private Team saveTeam(@RequestBody Team team){
        return teamService.saveTeam(team);
    }
}
