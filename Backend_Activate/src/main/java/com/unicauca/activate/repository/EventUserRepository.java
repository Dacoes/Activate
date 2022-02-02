package com.unicauca.activate.repository;

import com.unicauca.activate.model.EventUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventUserRepository extends JpaRepository<EventUser, Long>{
    
}
