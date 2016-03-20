package dungeonmart;

import com.jayway.restassured.RestAssured;
import dungeonmart.ref.v35.ClassesApplication;
import dungeonmart.ref.v35.classes.entities.ClassCharacter;
import dungeonmart.ref.v35.classes.repositories.ClassRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ClassesApplication.class)
@ActiveProfiles("dev")
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ClassControllerITests {

    @Autowired
    private ClassRepository classRepository;

    private ClassCharacter testClass;

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() {
        testClass = ClassCharacter.builder().name("Test Class").build();

        classRepository.deleteAll();
        classRepository.save(testClass);

        RestAssured.port = port;
    }

    @Test
    public void canFetchTestClass() {
        when()
                .get("/classes/{classId}", testClass.getClassCharacterId())
            .then()
                .statusCode(200)
                .body("name", Matchers.is("Test Class"));
    }
}
