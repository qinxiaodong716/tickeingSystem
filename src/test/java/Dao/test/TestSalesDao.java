package Dao.test;
/*
 * SalesDao测试类
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IAdminDao;
import dao.prototype.ISalesDao;
import entity.Admin;
import entity.Sales;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestSalesDao {

	@Autowired
	private ISalesDao isd;
	
	@Test
	public void testSaveOrUpdate() {
		Sales sales = new Sales(3,4,"qxd","123","15103467169");
		System.out.println(isd.saveOrUpdate(sales));
	}
	
	@Test
	public void testLogin() {
		System.out.println(isd.login("15103467169", "123"));
	}
	
	@Test
	public void testDelete() {
		System.out.println(isd.delete(3));
	}
	
}