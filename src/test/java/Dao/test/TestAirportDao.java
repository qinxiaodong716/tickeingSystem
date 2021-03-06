package Dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IAirportDao;
import entity.Airport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestAirportDao {
	@Autowired
	private IAirportDao iad;
	
	@Test
	public void TestSave() {
		Airport airport = new Airport("cq","CKJ","jiangbei");
		System.out.println(iad.save(airport));
	}
	@Test
	public void TestDelete() {
		System.out.println(iad.delete("bj"));
	}
	@Test
	public void TestUpdate() {
		Airport airport = new Airport("sh","PIK","shoudu");
		System.out.println(iad.update(airport));
	}
	@Test 
	public void TestFind() {
		System.out.println(iad.find("sh"));
	}
	@Test 
	public void TestFindAll(){
		System.out.println(iad.findAll());
	}
}
