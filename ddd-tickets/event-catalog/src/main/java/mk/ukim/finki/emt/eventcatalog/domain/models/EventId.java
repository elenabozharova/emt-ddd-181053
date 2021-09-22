package mk.ukim.finki.emt.eventcatalog.domain.models;


import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class EventId extends DomainObjectId {

    public EventId() {

        super(EventId.randomId(EventId.class).getId());
    }

    public EventId(@NonNull String uuid) {

        super(uuid);
    }

    public static EventId of(String uuid) {
        EventId p = new EventId(uuid);
        return p;
    }
}
