package com.github.event.service;

import com.github.event.model.Event;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventService {

    int id=1;
    public Event createEvent(Event event){
        return Event.builder().id(id++)
                .actorID(event.getActorID())
                .repoID(event.getRepoID())
                .isPublic(event.getIsPublic())
                .type(event.getType()).build();
    }




}
