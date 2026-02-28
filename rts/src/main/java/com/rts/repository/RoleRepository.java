package com.rts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.pojo.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    

}
