package dungeonmart.ref.v35.classes.repositories;

import dungeonmart.ref.v35.classes.entities.ClassCharacter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends PagingAndSortingRepository<ClassCharacter, String> {
    //TODO Is there a fluent way of doing this (magic strings are bad)
    @Query("select c from ClassCharacter c where UPPER(c.name) like UPPER(?1) or " +
            "UPPER(c.fullText) like UPPER(?1)")
    List search(String term);
}
