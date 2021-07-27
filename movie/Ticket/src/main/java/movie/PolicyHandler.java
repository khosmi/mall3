package movie;

import movie.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired TicketRepository ticketRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayed_Ticket(@Payload Payed payed){

        if(!payed.validate()) return;

        System.out.println("\n\n##### listener Ticket : " + payed.toJson() + "\n\n");



        // Sample Logic //
        // Ticket ticket = new Ticket();
        // ticketRepository.save(ticket);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceledPay_CancelTicket(@Payload CanceledPay canceledPay){

        if(!canceledPay.validate()) return;

        System.out.println("\n\n##### listener CancelTicket : " + canceledPay.toJson() + "\n\n");



        // Sample Logic //
        // Ticket ticket = new Ticket();
        // ticketRepository.save(ticket);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
