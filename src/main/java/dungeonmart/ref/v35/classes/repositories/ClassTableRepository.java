package dungeonmart.ref.v35.classes.repositories;

import dungeonmart.ref.v35.classes.entities.ClassTable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClassTableRepository extends PagingAndSortingRepository<ClassTable, UUID> {
    List<ClassTable> findByName(String name);

    ClassTable findByNameAndLevel(String name, int level);
}
