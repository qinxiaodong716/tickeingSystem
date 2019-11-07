package service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import entity.AirplaneModel;
import service.prototype.IAirplaneModelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestAirplaneModelService {
	
	@Autowired
	private IAirplaneModelService iams;
	
	@Test
	public void testSave() {
		AirplaneModel apm = new AirplaneModel("A310-100",6820,12,20,204);
		System.out.println(iams.save(apm));
	}
	@Test
	public void testUpdate() {
		AirplaneModel apm = new AirplaneModel("A310-100",6820,12,20,222);
		System.out.println(iams.update(apm));
	}
	@Test
	public void testFind() {
		System.out.println(iams.find("A310-100"));
	}
	@Test
	public void testFindAll() {
		System.out.println(iams.findAll());
	}
	@Test
	public void testDelete() {
		System.out.println(iams.delete("A310-100"));
	}
}
