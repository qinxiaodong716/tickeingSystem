package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import service.prototype.IFlightService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestFilgthService {
	@Autowired
	private IFlightService ifs;
	
	@Test
	public void testListFlightSchedulers() {
		System.out.println(ifs.listFlight(1, 10));
	}
	
}
