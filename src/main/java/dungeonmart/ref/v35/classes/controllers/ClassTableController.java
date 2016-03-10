package dungeonmart.ref.v35.classes.controllers;

import dungeonmart.ref.v35.classes.entities.ClassCharacter;
import dungeonmart.ref.v35.classes.entities.ClassTable;
import dungeonmart.ref.v35.classes.repositories.ClassRepository;
import dungeonmart.ref.v35.classes.repositories.ClassTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/classes/{classId}/table")
public class ClassTableController {

    @Autowired
    private ClassTableRepository classTableRepository;

    @Autowired
    private ClassRepository classRepository;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<ClassTable>> getAll(@PathVariable("classId") UUID classId) {
        ClassCharacter classCharacter = classRepository.findOne(classId);
        List<ClassTable> classTableList = classTableRepository.findByName(classCharacter.getName());
        return new ResponseEntity<>(classTableList, HttpStatus.OK);
    }

    @RequestMapping(path = "/{level}", method = RequestMethod.GET)
    public HttpEntity<ClassTable> getOne(@PathVariable("classId") UUID classId, @PathVariable("level") int level) {
        ClassCharacter classCharacter = classRepository.findOne(classId);
        ClassTable classTable = classTableRepository.findByNameAndLevel(classCharacter.getName(), level);
        return new ResponseEntity<>(classTable, HttpStatus.OK);
    }
}
