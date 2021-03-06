package dungeonmart.ref.v35.classes.repositories;

import dungeonmart.ref.v35.classes.entities.ClassLevel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClassLevelRepository extends PagingAndSortingRepository<ClassLevel, UUID> {
    List<ClassLevel> findByName(String name);

    ClassLevel findByNameAndLevel(String name, int level);
}
