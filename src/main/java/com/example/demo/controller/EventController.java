package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController()
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events")
    public List<Event> getEvents() {
        Page<Event> events = eventRepository.findAll(PageRequest.of(0, 10, Sort.Direction.DESC, "date"));
        return events.getContent();
    }

    @PostMapping("/events")
    public Event createEvent(@Valid @RequestBody Event event) {
        return eventRepository.save(event);
    }
}
