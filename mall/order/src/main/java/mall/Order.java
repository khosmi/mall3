package mall;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;
import org.springframework.boot.SpringApplication;

@Entity
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long productId;
    private Integer qty;
    private String productName;
    private String orderStatus;
    private String deliveryId;
    private String deliveryStattus;

    @PostPersist
    public void onPostPersist(){
        OrderPlaced orderPlaced = new OrderPlaced();
        BeanUtils.copyProperties(this, orderPlaced);
        orderPlaced.publishAfterCommit();

        //OrderCanceled orderCanceled = new OrderCanceled();
        //BeanUtils.copyProperties(this, orderCanceled);
        //orderCanceled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        //mall.external.Delivery delivery = new mall.external.Delivery();
        // mappings goes here
        //Application.applicationContext.getBean(mall.external.DeliveryService.class)
          //  .cancelDelivery(delivery);

    }

    @PreRemove
    public void onPreRemove(){
        OrderCanceled orderCanceled = new OrderCanceled();
        BeanUtils.copyProperties(this, orderCanceled);  //ORDER 를 복사한다
        orderCanceled.publishAfterCommit();

        // mall.external.Delivery delivery = new mall.external.Delivery();
        // mappings goes here
        //delivery.setId(this.getDeliveryId());
        OrderApplication.applicationContext.getBean(mall.external.DeliveryService.class)
            .cancelDelivery(this.getDeliveryId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }
    public String getDeliveryStattus() {
        return deliveryStattus;
    }

    public void setDeliveryStattus(String deliveryStattus) {
        this.deliveryStattus = deliveryStattus;
    }




}
