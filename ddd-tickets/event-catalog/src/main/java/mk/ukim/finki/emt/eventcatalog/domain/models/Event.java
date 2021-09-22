package mk.ukim.finki.emt.eventcatalog.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@Getter
public class Event extends AbstractEntity<EventId> {

    private String eventName;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String address;

    private String type; // concert, play

    private int sales = 0; // number of sales for this event

    private Event()
    {
        super(EventId.randomId(EventId.class));
    }

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })

    private Money price;

    public Event (String eventName, Money price, int sales) {
        Event e = new Event();
        e.eventName = eventName;
        e.price = price;
        e.sales = sales;
    }

    public static Event build(String eventName, Money price, int sales) {
        Event e = new Event();
        e.eventName = eventName;
        e.price = price;
        e.sales = sales;
        return e;
    }

    // send notification to event that the number of sales is bigger
    public void addSales(int qty) {

        this.sales = this.sales - qty;
    }

    public void removeSales(int qty) {

        this.sales -= qty;
    }

}
