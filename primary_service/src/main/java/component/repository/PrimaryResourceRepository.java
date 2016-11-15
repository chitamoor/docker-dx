package component.repository;

import component.domain.PrimaryResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryResourceRepository extends CrudRepository<PrimaryResource,Integer>{
}
