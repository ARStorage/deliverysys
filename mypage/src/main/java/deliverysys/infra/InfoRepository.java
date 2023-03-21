package deliverysys.infra;

import deliverysys.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "infos", path = "infos")
public interface InfoRepository extends PagingAndSortingRepository<Info, Long> {
    List<Info> findByOrderId(String orderId);
}
