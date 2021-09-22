package mk.ukim.finki.emt.eventcatalog.services;

import mk.ukim.finki.emt.eventcatalog.domain.dto.EventDto;
import mk.ukim.finki.emt.eventcatalog.domain.models.Event;
import mk.ukim.finki.emt.eventcatalog.domain.models.EventId;
import mk.ukim.finki.emt.eventcatalog.services.form.EventForm;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Optional<Event> findById(EventId id);
    Optional<Event> save(EventDto dto);
    Optional<Event> edit(String id, EventDto eventDto);
    void deleteById(String id);
    Event createEvent(EventForm form);
    Event orderItemCreated(EventId eventId, int quantity);
    Event orderItemRemoved(EventId eventId, int quantity);
    List<Event> getAll();
}
