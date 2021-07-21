package mall;

import mall.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryStarted_UpdateStatus(@Payload DeliveryStarted deliveryStarted){

        if(!deliveryStarted.validate()) return;

        System.out.println("\n\n##### listener UpdateStatus : " + deliveryStarted.toJson() + "\n\n");

        // Sample Logic // KHOS
        java.util.Optional<Order> optionalOrder = orderRepository.findById(deliveryStarted.getOrderId());
        Order order = optionalOrder.get();
        order.setDeliveryId(deliveryStarted.getId());
        order.setOrderStatus(deliveryStarted.getDeliveryStatus());

        //   List<Order> orderList = OrderRepository.findById(deliveryStarted.getOrderId());
        //order.setId(deliveryStarted.getOrderId());
        //  order.setOrderStatus(deliveryStarted.getDeliveryStatus());
        orderRepository.save(order);
        
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
