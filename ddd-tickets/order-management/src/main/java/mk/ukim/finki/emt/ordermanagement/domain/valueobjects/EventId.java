package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class EventId extends DomainObjectId {
    private EventId() {
        super(EventId.randomId(EventId.class).getId());
    }

    public EventId(String uuid) {
        super(uuid);
    }

}
