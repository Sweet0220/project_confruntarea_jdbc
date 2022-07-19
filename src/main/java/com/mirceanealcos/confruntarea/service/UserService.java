package com.mirceanealcos.confruntarea.service;


import com.mirceanealcos.confruntarea.entity.User;
import com.mirceanealcos.confruntarea.repo.UC_LinkRepository;
import com.mirceanealcos.confruntarea.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UC_LinkRepository uc_linkRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public int deleteUsers() {
        uc_linkRepository.deleteAll();
        return userRepository.deleteAll();
    }

    public void deleteById(Long id) {
        uc_linkRepository.deleteByUserId(id);
        userRepository.deleteById(id);
    }

    public boolean updateUser(Long id, User user) {
        User updatedUser = userRepository.findById(id);
        if (updatedUser != null) {
            updatedUser.setId(id);
            updatedUser.setEmail(user.getEmail());
            updatedUser.setFunds(user.getFunds());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setRole(user.getRole());
            updatedUser.setUsername(user.getUsername());
            userRepository.update(updatedUser);
            return true;
        }
        return false;
    }
}
