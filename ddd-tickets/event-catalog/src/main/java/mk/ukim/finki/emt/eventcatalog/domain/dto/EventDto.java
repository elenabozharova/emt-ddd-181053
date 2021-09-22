package mk.ukim.finki.emt.eventcatalog.domain.dto;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;

import java.time.LocalDateTime;

@Data
public class EventDto {
    private String eventName;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String address;

    private String type; // concert, play

    private int sales = 0; // number of sales for this event

    private int amount;

    private Currency currency;

    public EventDto(String eventName, LocalDateTime startTime, LocalDateTime endTime, String address, String type, int sales, int amount, Currency currency) {
        this.eventName = eventName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
        this.type = type;
        this.sales = sales;
        this.amount = amount;
        this.currency = currency;
    }
}
