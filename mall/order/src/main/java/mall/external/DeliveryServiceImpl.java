package mall.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService{

    /**
     * 배송 fallback
     */
    public void cancelDelivery(String id) {
        System.out.println("@@@@@@@" + id +" 배송취소 지연중 입니다. @@@@@@@@@@@@");
        System.out.println("@@@@@@@" + id +" 배송취소 지연중 입니다. @@@@@@@@@@@@");
        System.out.println("@@@@@@@" + id +" 배송취소 지연중 입니다. @@@@@@@@@@@@");
    }

}