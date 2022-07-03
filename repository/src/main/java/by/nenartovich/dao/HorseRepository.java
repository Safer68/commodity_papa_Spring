package by.nenartovich.dao;

import by.nenartovich.entity.Horse;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorseRepository extends CrudRepository<Horse, Long>, JpaSpecificationExecutor<Horse> {

}
