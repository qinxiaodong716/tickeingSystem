package Dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IOrderDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestOrderDao {
	@Autowired
	private IOrderDao iod;
	
	
	@Test
	public void testfind() {
		System.out.println(iod.find(4));
	}
	@Test
	public void testphonefind() {
		System.out.println(iod.find("15103467169"));
	}
	@Test
	public void testupdata() {
		System.out.println(iod.updata(112,"yfk"));
	}
}
