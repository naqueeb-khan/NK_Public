package com.rts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.pojo.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
 
}
