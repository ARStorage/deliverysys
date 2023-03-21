package deliverysys.domain;

import deliverysys.StoreApplication;
import deliverysys.domain.CookFinished;
import deliverysys.domain.CookStarted;
import deliverysys.domain.OrderAccepted;
import deliverysys.domain.OrderRejected;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cook_table")
@Data
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String customerId;

    private String address;

    private String status;

    private String foodId;

    private Integer qty;

    private String storeId;

    @PostPersist
    public void onPostPersist() {
        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();

        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    //<<< Clean Arch / Port Method
    public static void orderCreate(Paid paid) {
        Cook cook = new Cook();
        cook.setAddress(paid.getAddress());
        cook.setCustomerId(paid.getCustomerId());
        cook.setFoodId(paid.getFoodId());
        cook.setOrderId(String.valueOf(paid.getId()));
        cook.setQty(paid.getQty());
        cook.setStoreId(paid.getStoreId());
        cook.setStatus("주문 승낙");
        repository().save(cook);

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void orderDelete(OrderCanceled orderCanceled) {
        repository().findByOrderId(orderCanceled.getId()).ifPresent(cook->{
            
            cook.setStatus("주문 취소");
            repository().save(cook);


         });

    }
    //>>> Clean Arch / Port Method

}
