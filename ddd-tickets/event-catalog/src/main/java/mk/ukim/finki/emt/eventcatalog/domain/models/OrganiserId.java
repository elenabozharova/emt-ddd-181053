package mk.ukim.finki.emt.eventcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class OrganiserId extends DomainObjectId {
    public OrganiserId() {

        super(OrganiserId.randomId(EventId.class).getId());
    }

    public OrganiserId(@NonNull String uuid) {

        super(uuid);
    }

    public static OrganiserId of(String uuid) {
        OrganiserId p = new OrganiserId(uuid);
        return p;
    }
}
