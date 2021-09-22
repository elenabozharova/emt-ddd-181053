package mk.ukim.finki.emt.eventcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.eventcatalog.domain.dto.EventDto;
import mk.ukim.finki.emt.eventcatalog.domain.models.Event;
import mk.ukim.finki.emt.eventcatalog.domain.models.EventId;
import mk.ukim.finki.emt.eventcatalog.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class EventResource {
    private final EventService eventService;

    @GetMapping
    public List<Event> getAll() {
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable String id) {
        EventId eventId = EventId.of(id);
        return this.eventService.findById(eventId)
                .map(event -> ResponseEntity.ok().body(event))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Event> save(@RequestBody EventDto eventDto) {
        return this.eventService.save(eventDto)
                .map(event -> ResponseEntity.ok().body(event))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Event> save(@PathVariable String id, @RequestBody EventDto eventDto) {
        return this.eventService.edit(id, eventDto)
                .map(event -> ResponseEntity.ok().body(event))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        this.eventService.deleteById(id);
        EventId eventId = EventId.of(id);
        if(this.eventService.findById(eventId).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
