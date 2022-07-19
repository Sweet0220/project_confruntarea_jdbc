package com.mirceanealcos.confruntarea.repo;

import com.mirceanealcos.confruntarea.entity.User;

import java.util.List;

public interface UserRepository {
    int save(User user);
    int update(User user);
    User findById(Long id);
    int deleteById(Long id);
    List<User> findAll();
    User findByEmail(String email);
    int deleteAll();
}
