package gov.dwp.jbes2000;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import uk.gov.dwp.jbes2000.departure.DwpJbes2000DepartureApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DwpJbes2000DepartureApplication.class)
@WebAppConfiguration
public class Jbes2000ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
