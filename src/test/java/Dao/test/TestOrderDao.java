package Dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IOrderDao;
import entity.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestOrderDao {
	@Autowired
	private IOrderDao iod;
	
	@Test
	public void testSave() {
		Order order = new Order(1,200.0,"yfk","400600");
		System.out.println(iod.save(order));
	}
	@Test
	public void testfind() {
		System.out.println(iod.find(1));
	}
}
