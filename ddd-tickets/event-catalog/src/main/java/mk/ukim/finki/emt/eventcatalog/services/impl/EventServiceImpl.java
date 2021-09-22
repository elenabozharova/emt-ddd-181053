package mk.ukim.finki.emt.eventcatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.eventcatalog.domain.dto.EventDto;
import mk.ukim.finki.emt.eventcatalog.domain.exceptions.EventNotFoundException;
import mk.ukim.finki.emt.eventcatalog.domain.models.Event;
import mk.ukim.finki.emt.eventcatalog.domain.models.EventId;
import mk.ukim.finki.emt.eventcatalog.domain.respository.EventRepository;
import mk.ukim.finki.emt.eventcatalog.services.EventService;
import mk.ukim.finki.emt.eventcatalog.services.form.EventForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public Optional<Event> findById(EventId id) {
        return Optional.of(eventRepository.findById(id)).orElseThrow(EventNotFoundException::new);
    }

    @Override
    public Optional<Event> save(EventDto dto) {
        return Optional.empty();
    }

    @Override
    public Optional<Event> edit(String id, EventDto eventDto) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Event createEvent(EventForm form) {
        Event e = Event.build(form.getEventName(), form.getPrice(),form.getSales());
        eventRepository.save(e);
        return e;
    }

    @Override
    public Event orderItemCreated(EventId eventId, int quantity) {
        Event p = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);
        p.addSales(quantity);
        eventRepository.saveAndFlush(p);
        return p;
    }

    @Override
    public Event orderItemRemoved(EventId eventId, int quantity) {
        Event e = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);
        e.removeSales(quantity);
        eventRepository.saveAndFlush(e);
        return e;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

}
