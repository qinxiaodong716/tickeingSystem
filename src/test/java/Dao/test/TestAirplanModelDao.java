package Dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import dao.prototype.IAirplaneModelDao;
import entity.AirplaneModel;

/*
 * AirplanModelDao测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestAirplanModelDao {
	@Autowired
	private IAirplaneModelDao iad;
	
	@Test
	public void testSave() {
		AirplaneModel apm = new AirplaneModel("A310-600",6820,12,20,228);
		System.out.println(iad.save(apm));
	}
	@Test
	public void testUpdate() {
		AirplaneModel apm = new AirplaneModel("A310-100",6820,12,20,204);
		System.out.println(iad.update(apm));
	}
	@Test
	public void testFind() {
		System.out.println(iad.find("A310-100"));
	}
	@Test
	public void testFindAll() {
		System.out.println(iad.findAll());
	}
	@Test
	public void testDelete() {
		System.out.println(iad.delete("A310-100"));
	}
}
