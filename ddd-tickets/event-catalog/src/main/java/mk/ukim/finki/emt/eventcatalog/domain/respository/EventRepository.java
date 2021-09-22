package mk.ukim.finki.emt.eventcatalog.domain.respository;

import mk.ukim.finki.emt.eventcatalog.domain.models.Event;
import mk.ukim.finki.emt.eventcatalog.domain.models.EventId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, EventId> {
}
