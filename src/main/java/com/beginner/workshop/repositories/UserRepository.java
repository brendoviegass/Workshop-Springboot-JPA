package com.beginner.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beginner.workshop.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
