package mk.ukim.finki.emt.eventcatalog.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.eventcatalog.domain.models.EventId;
import mk.ukim.finki.emt.eventcatalog.services.EventService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemCreated;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemRemoved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventListener {
    private final EventService eventService;

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_ITEM_CREATED, groupId = "productCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            OrderItemCreated event = DomainEvent.fromJson(jsonMessage,OrderItemCreated.class);
            eventService.orderItemCreated(EventId.of(event.getEventId()), event.getQuantity());
        } catch (Exception e){

        }

    }

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_ITEM_REMOVED, groupId = "productCatalog")
    public void consumeOrderItemRemovedEvent(String jsonMessage) {
        try {
            OrderItemRemoved event = DomainEvent.fromJson(jsonMessage,OrderItemRemoved.class);
            eventService.orderItemRemoved(EventId.of(event.getEventId()), event.getQuantity());
        } catch (Exception e){

        }

    }

}
