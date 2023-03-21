package deliverysys.domain;

import deliverysys.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class DeliveryFinished extends AbstractEvent {

    private Long id;
    private String orderId;
    private String address;
    private String status;
    private String customerId;
    private String storeId;
}
