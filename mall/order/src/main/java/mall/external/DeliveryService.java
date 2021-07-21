
package mall.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

// khos req/res 호출, circuit Breaker Fallback 처리
@FeignClient(name="delivery", url="http://localhost:8082", fallback = DeliveryServiceImpl.class)
public interface DeliveryService {

    //방법 1
   @RequestMapping(method= RequestMethod.DELETE, path="/deliveries/{id}")
   public void cancelDelivery(@PathVariable String id);

   // Controller 사용
   //@RequestMapping(method= RequestMethod.DELETE, path="/deliveries/cancelDelivery")
   //public void cancelDelivery(@PathVariable String id);
}





