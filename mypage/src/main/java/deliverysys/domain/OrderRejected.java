package deliverysys.domain;

import deliverysys.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class OrderRejected extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private String address;
    private String status;
    private String foodId;
    private Integer qty;
    private String storeId;
}
