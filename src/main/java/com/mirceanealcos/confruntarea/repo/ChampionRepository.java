package com.mirceanealcos.confruntarea.repo;

import com.mirceanealcos.confruntarea.entity.Champion;

import java.util.List;

public interface ChampionRepository {

    int save(Champion champ);

    int update(Champion champ);

    Champion findById(Long id);

    int deleteById(Long id);

    List<Champion> findAll();

    Champion findByName(String name);

    int deleteAll();

}
