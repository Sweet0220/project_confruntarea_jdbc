package com.mirceanealcos.confruntarea.repo;

import com.mirceanealcos.confruntarea.entity.UC_Link;

import java.util.List;

public interface UC_LinkRepository {

    int save(UC_Link link);

    int update(UC_Link old_link, UC_Link new_link);

    List<UC_Link> findAll();

    List<UC_Link> findByUserId(Long user_id);

    List<UC_Link> findByChampionId(Long champion_id);

    int deleteAll();

    int deleteByUserId(Long user_id);

    int deleteByChampionId(Long champion_id);

}
