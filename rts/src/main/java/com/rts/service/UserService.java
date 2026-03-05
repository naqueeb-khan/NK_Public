package com.rts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rts.pojo.Role;
import com.rts.pojo.User;
import com.rts.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    @Autowired
    RoleService rserv;

    @Transactional
    public User saveOrUpdate(User user) {
        user.setEmail(user.getEmail().toLowerCase());
        Role role = rserv.findById(user.getRole());
        if (role != null) {
            return repo.save(user);
        }
        return null;
    }

    @Transactional
    public boolean delete(User user) {
        boolean result = false;
        repo.delete(user);
        result = true;
        return result;
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "users", key = "#Id")
    public User findById(User user) {
        return repo.findById(user.getId()).orElse(null);
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "users", key = "'ByEmail'")
    public User findByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "users", key = "'all'")
    public List<User> findAll(User user) {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
   @Cacheable(value = "users", key = "'Anyall'")
    public List<User> findByAny(User user) {
        Example<User> ex = Example.of(user);
        return repo.findAll(ex);
    }
}
