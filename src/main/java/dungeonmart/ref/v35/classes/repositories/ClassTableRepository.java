package dungeonmart.ref.v35.classes.repositories;

import dungeonmart.ref.v35.classes.entities.ClassTable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassTableRepository extends PagingAndSortingRepository<ClassTable, Long> {
}
