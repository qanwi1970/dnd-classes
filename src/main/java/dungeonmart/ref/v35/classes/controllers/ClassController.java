package dungeonmart.ref.v35.classes.controllers;

import dungeonmart.ref.v35.classes.entities.ClassCharacter;
import dungeonmart.ref.v35.classes.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/classes")
public class ClassController {
    private final ClassRepository classRepository;

    @Autowired
    public ClassController(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable findAll(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                            @RequestParam(value = "count", defaultValue = "10", required = false) int count,
                            @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
                            @RequestParam(value = "sort", defaultValue = "name", required = false) String sortProperty) {
        Page result = classRepository.findAll(new PageRequest(page, count, new Sort(direction, sortProperty)));
        return result.getContent();
    }

    @RequestMapping(value = "/{classId}", method = RequestMethod.GET)
    public ClassCharacter find(@PathVariable UUID classId) {
        ClassCharacter classCharacter = classRepository.findOne(classId);
        if (classCharacter == null) {
            throw new CharacterClassNotFoundException();
        } else {
            return classCharacter;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ClassCharacter create(@RequestBody @Valid ClassCharacter classCharacter) {
        long now = Instant.now().getEpochSecond();
        classCharacter.setCreatedTime(now);
        classCharacter.setModifiedTime(now);
        return classRepository.save(classCharacter);
    }

    @RequestMapping(value = "/{classId}", method = RequestMethod.PUT)
    public ClassCharacter update(@PathVariable UUID classId, @RequestBody @Valid ClassCharacter classCharacter) {
        ClassCharacter oldClass = classRepository.findOne(classId);
        if (oldClass == null) throw new CharacterClassNotFoundException();

        classCharacter.setClassCharacterId(classId);
        classCharacter.setCreatedTime(oldClass.getCreatedTime());
        classCharacter.setModifiedTime(Instant.now().getEpochSecond());

        return classRepository.save(classCharacter);
    }

    @RequestMapping(value = "/{classId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable UUID classId) {
        classRepository.delete(classId);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    static class CharacterClassNotFoundException extends RuntimeException {
    }
}
