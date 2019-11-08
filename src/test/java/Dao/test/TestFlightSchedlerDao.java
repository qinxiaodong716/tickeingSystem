package Dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IFlightSchedulerDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestFlightSchedlerDao {
	
	@Autowired
	private IFlightSchedulerDao ifsd;
	
	@Test
	public void testDelete() {
		System.out.println(ifsd.delete("YH0001"));
	}
}
