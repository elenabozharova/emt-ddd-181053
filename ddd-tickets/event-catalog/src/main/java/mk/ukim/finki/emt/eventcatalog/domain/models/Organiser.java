package mk.ukim.finki.emt.eventcatalog.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="organiser")
@Getter
public class Organiser extends AbstractEntity<OrganiserId> {
    public String imageSrc;
    public String name;
    private String contactMail;

}
