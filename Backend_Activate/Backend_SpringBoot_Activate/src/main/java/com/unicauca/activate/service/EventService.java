/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.activate.service;



import com.unicauca.activate.model.Event;
import com.unicauca.activate.repository.EventRespository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 57322
 */
@Service
public class EventService implements IEventService {

    @Autowired
    private EventRespository eventRepository;

    @Override
    @Transactional(readOnly = true) //Solamente va a leer información
    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Event> findAll(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    @Transactional //Puede leer escribir
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

}
