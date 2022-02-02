package com.unicauca.activate.controller;

import java.util.Optional;

import com.unicauca.activate.model.Asistence;
import com.unicauca.activate.model.Event;
import com.unicauca.activate.model.EventUser;
import com.unicauca.activate.model.User;
import com.unicauca.activate.service.EventService;
import com.unicauca.activate.service.IEventUserService;
import com.unicauca.activate.service.IUserService;
import com.unicauca.activate.utilities.JWTUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activate/assist")

public class EventUserController {
    
    @Autowired
    private IEventUserService EventUserService;

    @Autowired
    private IUserService UserService;

    @Autowired
    private EventService EventService;

    @Autowired
    private JWTUtilities jwUtil;

    //Crear Asistencia
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestHeader(value="Authorization") String token, @RequestHeader(value="Event_id") String event_id) {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        Long usuarioID = Long.parseLong(jwUtil.getKey(token)); 
        Long eventoID = Long.parseLong(event_id); 
        Asistence asistence = new Asistence(usuarioID, eventoID);

        System.out.println(asistence.toString());
        Optional<User> user = UserService.findById(asistence.getIdentificacionUsuario());
        Optional<Event> event = EventService.findById(asistence.getIdentificacionEvento());

        EventUser eventUser = new EventUser();
        eventUser.setEvent(event.get());
        eventUser.setUser(user.get());
        
        EventUser save = EventUserService.save(eventUser);
        
        return ResponseEntity.ok().body(save);
    }
}
