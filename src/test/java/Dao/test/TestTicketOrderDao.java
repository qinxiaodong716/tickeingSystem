package Dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IAdminDao;
import dao.prototype.ITicketOrderDao;
import entity.Admin;
import entity.TicketOrder;

/*
 * TicketOrderDao测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestTicketOrderDao {

	@Autowired
	private ITicketOrderDao itd;
	
	@Test
	public void testSaveOrUpdate() {
		TicketOrder ticketOrder= new TicketOrder(10,"qxd","141124199807010170","2019-10-01","1","c",20,30);
		System.out.println(itd.saveOrUpdate(ticketOrder));
	}
	
	
	@Test
	public void testDelete() {
		System.out.println(itd.delete(2));
	}
	
}