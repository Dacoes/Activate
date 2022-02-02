package com.unicauca.activate.service;

import java.util.Optional;

import com.unicauca.activate.model.EventUser;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

public interface IEventUserService {
    public Iterable<EventUser> findAll();

    public Page<EventUser> findAll(Pageable pageable);

    public Optional<EventUser> findById(Long id);

    public EventUser save(EventUser eventUser);
    
    public void deleteById(Long id);

}
