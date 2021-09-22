package mk.ukim.finki.emt.eventcatalog.services.form;

import lombok.Data;
import mk.ukim.finki.emt.eventcatalog.domain.enums.EventType;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.time.LocalDateTime;

@Data
public class EventForm {
    private String eventName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String address;
    private EventType eventType;
    private Money price;
    private int sales;
}
