
package mall;

public class DeliveryStarted extends AbstractEvent {

    private String id;
    private Long orderId;
    private Long productId;
    private String porductName;
    private String deliveryStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getPorductName() {
        return porductName;
    }

    public void setPorductName(String porductName) {
        this.porductName = porductName;
    }
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}

