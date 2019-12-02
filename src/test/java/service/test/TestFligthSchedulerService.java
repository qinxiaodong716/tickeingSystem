package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.FlightScheduler;
import service.prototype.IFlightSchedulerService;

/*
 * FligthScheduler Service层测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestFligthSchedulerService {
	@Autowired
	private IFlightSchedulerService ifss;
	
	@Test
	public void Testfind() {
		System.out.println(ifss.listFlightSchedulers("北京", "上海", "2019-11-08"));
	}
	@Test
	public void Testfind1() {
		System.out.println(ifss.flightSchedulers("400600"));
	}
	@Test
	public void TestfindAll() {
		System.out.println(ifss.findAll());
	}
	@Test
	public void Testsave() {
		FlightScheduler fs = new FlightScheduler("400604", "2019-11-25", "2019-11-25", "PVG", "PEK","2019-11-25 8:40", "2019-11-25 12:20",  "A320", "1234567", 800, 1250.4);
		System.out.println(ifss.saveOrUpdate(fs));
	}
}
