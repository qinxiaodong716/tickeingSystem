package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import service.prototype.IFlightSchedulerService;

/*
 * BranchDao测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestFilgthSchedlerService {
	@Autowired
	private IFlightSchedulerService ifs;
	
	@Test
	public void testListFlightSchedulers() {
		System.out.println(ifs.listFlightSchedulers(1, 10));
	}
	
}
