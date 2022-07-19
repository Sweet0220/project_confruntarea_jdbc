package com.mirceanealcos.confruntarea.repo;

import com.mirceanealcos.confruntarea.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM User",BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO User (username, email, password, role, funds) VALUES (?,?,?,?,?)",
                user.getUsername(), user.getEmail(), user.getPassword(), user.getRole(), user.getFunds());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("UPDATE User SET username=?, email=?, password=?, role=?, funds=? WHERE id=?",
                user.getUsername(), user.getEmail(), user.getPassword(), user.getRole(), user.getFunds(), user.getId());
    }

    @Override
    public User findById(Long id) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM User WHERE id=?", BeanPropertyRowMapper.newInstance(User.class), id);
            return user;
        }catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM User WHERE id=?",id);
    }

    @Override
    public User findByEmail(String email) {
        try{
            User user = jdbcTemplate.queryForObject("SELECT * FROM User WHERE email=?", BeanPropertyRowMapper.newInstance(User.class), email);
            return user;
        }catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM User");
    }
}
