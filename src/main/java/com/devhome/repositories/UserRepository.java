package com.devhome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devhome.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}