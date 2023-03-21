package deliverysys.domain;

import deliverysys.RiderApplication;
import deliverysys.domain.CookPickuped;
import deliverysys.domain.DeliveryFinished;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String address;

    private String status;

    private String customerId;

    private String storeId;

    @PostPersist
    public void onPostPersist() {}

    @PostUpdate
    public void onPostUpdate() {
        DeliveryFinished deliveryFinished = new DeliveryFinished(this);
        deliveryFinished.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        CookPickuped cookPickuped = new CookPickuped(this);
        cookPickuped.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void deliveryCreate(CookFinished cookFinished) {
        Delivery delivery = new Delivery();
        delivery.setAddress(cookFinished.getAddress());
        delivery.setCustomerId(cookFinished.getCustomerId());
        delivery.setOrderId(cookFinished.getOrderId());
        delivery.setStoreId(cookFinished.getStoreId());

        repository().save(delivery);

    }
    //>>> Clean Arch / Port Method

}
