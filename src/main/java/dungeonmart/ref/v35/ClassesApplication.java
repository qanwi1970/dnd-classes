package dungeonmart.ref.v35;

import dungeonmart.ref.v35.classes.controllers.ClassSeedController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClassesApplication {

	@Bean
    CommandLineRunner seedData(ClassSeedController classSeedController) {
        return (evt) -> {
            classSeedController.seedClasses();
            classSeedController.seedClassTables();
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(ClassesApplication.class, args);
	}

}
