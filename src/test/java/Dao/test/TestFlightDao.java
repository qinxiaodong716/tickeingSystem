package Dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IFlightDao;
import entity.Flight;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestFlightDao {
	@Autowired
	private IFlightDao ifd;
	
	@Test
	public void testDelete() {
		System.out.println(ifd.delete(1));
	}
	
	@Test
	public void testSaveOrUpdate() {
		Flight flight = new Flight("li","2020-10-10",1,1,1,1.2);
		System.out.println(ifd.saveOrUpdate(flight));
	}
	@Test
	public void testListFlightSchedulers2() {
		System.out.println(ifd.listFlight("400600","2019-11-08").get(0).getFlightId());
	}
}
