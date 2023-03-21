package deliverysys.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Info_table")
@Data
public class Info {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String customerId;
    private String orderId;
    private String status;
}
