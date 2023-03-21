package deliverysys.domain;

import deliverysys.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String customerId;
    private String storeId;
    private String foodId;
    private String address;
    private String status;
    private Integer qty;
}
