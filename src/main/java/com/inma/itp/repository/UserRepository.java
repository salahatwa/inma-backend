package com.inma.itp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inma.itp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
