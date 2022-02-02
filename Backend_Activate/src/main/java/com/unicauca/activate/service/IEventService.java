/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.activate.service;
import com.unicauca.activate.model.Event;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author 57322
 */
public interface IEventService {
    
    public Iterable<Event> findAll();

    public Page<Event> findAll(Pageable pageable);

    public Optional<Event> findById(Long id);

    public Event save(Event event);
    
    public void deleteById(Long id);
    
}
