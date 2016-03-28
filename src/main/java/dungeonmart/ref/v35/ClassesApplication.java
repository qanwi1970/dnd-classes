package dungeonmart.ref.v35;

import dungeonmart.ref.v35.classes.controllers.ClassSeedController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ClassesApplication {

	@Bean
    CommandLineRunner seedData(ClassSeedController classSeedController) {
        return (evt) -> {
            //classSeedController.seedClasses();
            //classSeedController.seedClassTables();
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(ClassesApplication.class, args);
	}

    @RestController
    static class HomeController {
        @RequestMapping("/")
        public HttpEntity<?> showHome() {
            Map<String, String> homeValues = new HashMap<>();
            homeValues.put("name", "DungeonMart DND v3.5 Reference");
            return new ResponseEntity<Object>(homeValues, HttpStatus.OK);
        }
    }

}
