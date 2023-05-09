package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventRepository repository;

    public Page<EventDTO> findAllPaged(Pageable pageable) {
        Page<Event> page = repository.findAll(pageable);
        return page.map(event -> new EventDTO(event));
    }


}
