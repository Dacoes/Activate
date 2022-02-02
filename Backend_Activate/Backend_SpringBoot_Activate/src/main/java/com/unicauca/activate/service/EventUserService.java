package com.unicauca.activate.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import com.unicauca.activate.model.EventUser;
import com.unicauca.activate.repository.EventUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EventUserService implements IEventUserService{

    @Autowired
    private EventUserRepository eventUserRepository;
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public Iterable<EventUser> findAll() {
        return eventUserRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EventUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EventUser> findById(Long id) {
        return eventUserRepository.findById(id);
    }

    @Override
    @Transactional
    public EventUser save(EventUser user) {
        return eventUserRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        eventUserRepository.deleteById(id);
    }

    
}
