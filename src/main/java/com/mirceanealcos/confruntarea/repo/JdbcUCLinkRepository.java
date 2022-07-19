package com.mirceanealcos.confruntarea.repo;

import com.mirceanealcos.confruntarea.entity.UC_Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUCLinkRepository implements UC_LinkRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(UC_Link link) {
        return jdbcTemplate.update("INSERT INTO uc_link (champion_id, user_id) VALUES (?,?)",
                link.getChampion_id(), link.getUser_id());
    }

    @Override
    public int update(UC_Link old_link, UC_Link new_link) {
        return jdbcTemplate.update("UPDATE uc_link SET user_id=?, champion_id=? WHERE user_id=? AND champion_id=?",
                new_link.getUser_id(), new_link.getChampion_id(), old_link.getUser_id(), old_link.getChampion_id());
    }

    @Override
    public List<UC_Link> findAll() {
        return jdbcTemplate.query("SELECT * FROM uc_link", BeanPropertyRowMapper.newInstance(UC_Link.class));
    }

    @Override
    public List<UC_Link> findByUserId(Long user_id) {
        return jdbcTemplate.query("SELECT * FROM uc_link WHERE user_id=?",BeanPropertyRowMapper.newInstance(UC_Link.class),user_id);
    }

    @Override
    public List<UC_Link> findByChampionId(Long champion_id) {
        return jdbcTemplate.query("SELECT * FROM uc_link WHERE champion_id=?", BeanPropertyRowMapper.newInstance(UC_Link.class), champion_id);
    }

    @Override
    public int deleteAll() {
        jdbcTemplate.update("ALTER TABLE uc_link AUTO_INCREMENT = 1");
        return jdbcTemplate.update("DELETE FROM uc_link;");
    }

    @Override
    public int deleteByUserId(Long user_id) {
        return jdbcTemplate.update("DELETE FROM uc_link WHERE user_id=?",user_id);
    }

    @Override
    public int deleteByChampionId(Long champion_id) {
        return jdbcTemplate.update("DELETE FROM uc_link WHERE champion_id=?",champion_id);
    }
}
