package deliverysys.domain;

import deliverysys.domain.*;
import deliverysys.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private String address;
    private String status;
    private String foodId;
    private Integer qty;
    private String storeId;
}
