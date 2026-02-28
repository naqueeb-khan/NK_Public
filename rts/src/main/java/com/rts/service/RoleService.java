package com.rts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rts.pojo.Role;
import com.rts.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    RoleRepository repo;

    @Transactional
    public Role saveOrUpdate(Role role) {
        return repo.save(role);
    }

    @Transactional
    public boolean delete(Role role) {
        boolean result = false;
        repo.delete(role);
        result = true;
        return result;
    }

    @Transactional(readOnly = true)
    public Role findById(Role role) {
        return repo.findById(role.getId()).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public List<Role> findByAny(Role role) {
        Example<Role> ex = Example.of(role);
        return repo.findAll(ex);
    }

}
