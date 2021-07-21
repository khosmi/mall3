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
    @Autowired DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderPlaced_DeliveryStart(@Payload OrderPlaced orderPlaced){

        if(!orderPlaced.validate()) return;

        System.out.println("\n\n##### listener DeliveryStart : " + orderPlaced.toJson() + "\n\n");

        // Sample Logic // KHOS 수정
        Delivery delivery = new Delivery();
        delivery.setOrderId(orderPlaced.getId());
        delivery.setProductId(orderPlaced.getProductId());
        delivery.setPorductName(orderPlaced.getProductName());
        delivery.setDeliveryStatus("DeliveryStarted");
        deliveryRepository.save(delivery);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
