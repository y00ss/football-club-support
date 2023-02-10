package com.example.spanner_db.service;

import com.example.spanner_db.dto.FanData;
import com.example.spanner_db.entity.Fan;
import com.example.spanner_db.repository.FanDataJoinRepository;
import com.example.spanner_db.repository.FanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe che uso per le join con le tabelle User e Team
 * */

@Service
public class FanService {

    private final FanDataJoinRepository fanDataJoinRepository;

    private final FanRepository fanRepository;


    public FanService(FanDataJoinRepository fanRepository, FanRepository fanRepository1) {
        this.fanDataJoinRepository = fanRepository;
        this.fanRepository = fanRepository1;
    }
    public Fan saveFan(Fan fan){
      return fanRepository.save(fan);
    }

    public List<FanData> findFansByTeamId(long idTeam) {
        return fanDataJoinRepository.findByQuery(idTeam);
    }

    public List<FanData> findFansByCityUsers(String cityName) {
        return fanDataJoinRepository.findByQueryFansByCityUser(cityName);
    }

    public List<FanData> getAllFans() {
        return fanDataJoinRepository.findByQueryAll();
    }
}
