package com.mirceanealcos.confruntarea.service;

import com.mirceanealcos.confruntarea.entity.Champion;
import com.mirceanealcos.confruntarea.repo.ChampionRepository;
import com.mirceanealcos.confruntarea.repo.UC_LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionService {

    @Autowired
    ChampionRepository championRepository;

    @Autowired
    UC_LinkRepository uc_linkRepository;

    public List<Champion> getAllChampions(){
        return championRepository.findAll();
    }

    public Champion getChampionById(Long id) {
        return championRepository.findById(id);
    }

    public Champion getChampionByName(String name) {
        return championRepository.findByName(name);
    }

    public void addNewChampion(Champion champ) {
        championRepository.save(champ);
    }

    public int deleteChampionById(Long id) {
        uc_linkRepository.deleteByChampionId(id);
        return championRepository.deleteById(id);
    }

    public int deleteAllChampions() {
        uc_linkRepository.deleteAll();
        return championRepository.deleteAll();
    }

    public boolean updateChampion(Long id, Champion champ) throws Exception{
        Champion updatedChamp = championRepository.findById(id);
        if(updatedChamp != null) {
            updatedChamp = makeChampion(id, champ);
            championRepository.update(updatedChamp);
            return true;
        }
        return false;
    }

    private Champion makeChampion(Long id, Champion champ) throws Exception {
        Champion updatedChamp = new Champion();
        if(champ.getName() != null) {
            updatedChamp.setName(champ.getName());
        }
        else {
            throw new Exception("Name not present!");
        }

        if(champ.getHp() != null){
            updatedChamp.setHp(champ.getHp());
        }
        else{
            throw new Exception("Hp not present!");
        }

        if(champ.getPower() != null){
            updatedChamp.setPower(champ.getPower());
        }
        else {
            throw new Exception("Power not present!");
        }

        updatedChamp.setId(id);

        return updatedChamp;
    }
}
