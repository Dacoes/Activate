/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.activate.repository;
import com.unicauca.activate.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 57322
 */
public interface EventRespository extends JpaRepository<Event, Long>{
    
    
    
}
