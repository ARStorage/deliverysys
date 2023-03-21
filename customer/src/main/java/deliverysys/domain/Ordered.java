package deliverysys.domain;

import deliverysys.domain.*;
import deliverysys.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Ordered extends AbstractEvent {

    private Long id;
    private String customerId;
    private String storeId;
    private String foodId;
    private String address;
    private String status;
    private Integer qty;

    public Ordered(Order aggregate) {
        super(aggregate);
    }

    public Ordered() {
        super();
    }
}
