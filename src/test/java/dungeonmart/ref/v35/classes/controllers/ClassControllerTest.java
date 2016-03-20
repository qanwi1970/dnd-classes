package dungeonmart.ref.v35.classes.controllers;

import dungeonmart.ref.v35.classes.entities.ClassCharacter;
import dungeonmart.ref.v35.classes.repositories.ClassRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ClassControllerTest {

    @InjectMocks
    private ClassController classController;

    @Mock
    private ClassRepository classRepository;

    @Mock
    private Page<ClassCharacter> classCharacterPage;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllShouldReturnAPageFromRepository() {
        // Arrange
        int page = 0;
        int count = 10;
        Sort.Direction direction = Sort.Direction.ASC;
        String property = "test";
        Mockito.when(classRepository.findAll(Mockito.any(PageRequest.class))).thenReturn(classCharacterPage);
        List<ClassCharacter> classCharacterList = new ArrayList<>();
        Mockito.when(classCharacterPage.getContent()).thenReturn(classCharacterList);

        // Act
        ResponseEntity<Iterable<ClassCharacter>> result = (ResponseEntity<Iterable<ClassCharacter>>)
                classController.findAll(page, count, direction, property);

        // Assert
        Assert.assertSame(classCharacterList, result.getBody());
    }

    @Test
    public void find() throws Exception {

    }

    @Test
    public void create() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }
}
