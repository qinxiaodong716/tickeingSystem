package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import service.prototype.IOrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestOrderService {
	
	@Autowired 
	public IOrderService ios;
	
	@Test
	public void testFind() {
		System.out.println(ios.find("19935813304"));
	}
}
