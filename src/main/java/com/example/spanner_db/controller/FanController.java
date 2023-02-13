package com.example.spanner_db.controller;

import com.example.spanner_db.dao.FanData;
import com.example.spanner_db.service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fan")
public class FanController {


    @Autowired
    FanService fanService;

    @GetMapping()
    public List<FanData> getAllFans(){
        return fanService.getAllFans();
    }

    @GetMapping("/{teamId}")
    public List<FanData> getFansByTeamId(@PathVariable(name = "teamId") String teamId){
        int id = Integer.parseInt(teamId);
        return fanService.findFansByTeamId(id);
    }


    @GetMapping("/city/{cityUsers}")
    public List<FanData> getFansByCityUsers(@PathVariable(name = "cityUsers") String cityName){
        return fanService.findFansByCityUsers(cityName);
    }
}
