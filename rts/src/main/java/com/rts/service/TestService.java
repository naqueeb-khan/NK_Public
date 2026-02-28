package com.rts.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.repository.TestRepository;

@Service
public class TestService {
    @Autowired 
    private TestRepository repo;

       public List<Map<String, Object>> getAllUsers(){
        return repo.getAllUsers();
    }
}
