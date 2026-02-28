package com.rts.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TestRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
@Transactional
 public List<Map<String, Object>> getAllUsers(){
        return jdbcTemplate.queryForList("SELECT * FROM test");
    }
}
