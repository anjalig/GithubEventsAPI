package com.github.event.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
public class Event {
    private Integer id;
    private String type;
    private Boolean isPublic;
    private Integer repoID;
    private Integer actorID;


}
