package component.repository;

import component.domain.SecondaryResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryResourceRepository extends CrudRepository<SecondaryResource,Integer>{
}
