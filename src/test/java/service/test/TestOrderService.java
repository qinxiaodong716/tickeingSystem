package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.Order;
import service.prototype.IOrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestOrderService {
	
	@Autowired 
	public IOrderService ios;
	
	@Test
	public void testFind() {
		System.out.println(ios.find(139));
	}
	@Test
	public void testFind1() {
		System.out.println(ios.find("19935813304"));
	}
	@Test
	public void testsave() {
		Order order = new Order(120, "wfk", "400600", 3, "19935813304", "qxd", "19935813304");
		System.out.println(ios.save(order));
	}
	@Test
	public void testupdata() {
		long orderId = 141;
		String status = "ytk";
		System.out.println(ios.updata(orderId, status));
	}
}
