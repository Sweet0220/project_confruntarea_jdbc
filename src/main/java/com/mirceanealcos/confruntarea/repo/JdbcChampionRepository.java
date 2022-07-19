package com.mirceanealcos.confruntarea.repo;

import com.mirceanealcos.confruntarea.entity.Champion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcChampionRepository implements ChampionRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Champion champ) {
        return jdbcTemplate.update("INSERT INTO Champion (name, hp, power) VALUES (?,?,?)",
                champ.getName(),champ.getHp(),champ.getPower());
    }

    @Override
    public int update(Champion champ) {
        return jdbcTemplate.update("UPDATE Champion SET name=?, hp=?, power=? WHERE id=?",
                champ.getName(),champ.getHp(),champ.getPower(),champ.getId());
    }

    @Override
    public Champion findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Champion WHERE id=?",BeanPropertyRowMapper.newInstance(Champion.class),id);
        }catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }

    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM Champion WHERE id=?",id);
    }

    @Override
    public List<Champion> findAll() {
        return jdbcTemplate.query("SELECT * FROM Champion", BeanPropertyRowMapper.newInstance(Champion.class));
    }

    @Override
    public Champion findByName(String name) {
        try{
            return jdbcTemplate.queryForObject("SELECT * FROM Champion WHERE name=?", BeanPropertyRowMapper.newInstance(Champion.class),name);
        }catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteAll() {
        jdbcTemplate.update("ALTER TABLE Champion AUTO_INCREMENT = 1");
        return jdbcTemplate.update("DELETE FROM Champion");
    }
}
