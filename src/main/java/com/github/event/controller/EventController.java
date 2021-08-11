package com.github.event.controller;

import com.github.event.model.Event;
import com.github.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class EventController {

    @Autowired
    EventService eventService;

    List<Event> githubEvents = new ArrayList<>();

    @PostMapping(path="/events", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Event>> createEvent(@RequestBody Event event){
        Event newEvent = eventService.createEvent(event);
        githubEvents.add(newEvent);
        return new ResponseEntity<>(githubEvents,HttpStatus.CREATED);
    }

    @GetMapping(path="/events", produces = MediaType.APPLICATION_JSON_VALUE )
    ResponseEntity<List<Event>> getAllEvents(){
        return new ResponseEntity<>(githubEvents,HttpStatus.OK);
    }

    @GetMapping(path = "/events/{eventID}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Event> getEventByID(@PathVariable int eventID){
        for(Event githubevent : githubEvents){
            if(githubevent.getId() == eventID){
                return new ResponseEntity<>(githubevent, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/repos/{repoID}/events")
    ResponseEntity<Event> getEventByRepoID(@PathVariable int repoID){
        for(Event githubevent : githubEvents){
            if(githubevent.getRepoID() == repoID){
                return new ResponseEntity<>(githubevent, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }


}
