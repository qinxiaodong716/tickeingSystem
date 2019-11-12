package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.Flight;
import service.prototype.IFlightService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestFilgthService {
	@Autowired
	private IFlightService ifs;
	
	@Test
	public void testListFlightSchedulers() {
		System.out.println(ifs.listFlight(1, 10));
	}
	
	@Test
	public void testSaveOrUpdate() {
		
		Flight flight = new Flight("ghg","2020-01-01",1,1,1,1);
		System.out.println(ifs.saveOrUpdate(flight));
	}
	
	@Test
	public void testDelete() {
		System.out.println(ifs.delete(3));
	}
	@Test
	public void testListFlightSchedulers2() {
		System.out.println(ifs.listFlightSchedulers("CKJ","PEk","2019-10-02"));
	}
}
