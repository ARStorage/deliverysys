package deliverysys.domain;

import deliverysys.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cooks", path = "cooks")
public interface CookRepository
    extends PagingAndSortingRepository<Cook, Long> {

        java.util.Optional<Cook> findByOrderId(Long id);
    }
