package dungeonmart;

import dungeonmart.ref.v35.ClassesApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ClassesApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ClassesApplicationTests {

	@Test
	public void contextLoads() {
	}

}
