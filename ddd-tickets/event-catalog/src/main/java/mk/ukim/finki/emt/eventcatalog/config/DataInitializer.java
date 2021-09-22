package mk.ukim.finki.emt.eventcatalog.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.eventcatalog.domain.models.Event;
import mk.ukim.finki.emt.eventcatalog.domain.respository.EventRepository;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/*@Component
@AllArgsConstructor
public class DataInitializer {
    private final EventRepository eventRepository;

    @PostConstruct
    public void initData() {
        Event event1 = Event.build("Event 1", Money.valueOf(Currency.MKD, 100), 10);
        Event event2 = Event.build("Event 2", Money.valueOf(Currency.MKD, 150), 10);
        if(eventRepository.findAll().isEmpty())
        {
            eventRepository.saveAll(Arrays.asList(event1, event2));
        }
    }
}*/
