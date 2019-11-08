package Dao.test;

/*
 * 测试PeopleDao代码
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import dao.prototype.IPeopleDao;
import entity.People;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestPeopleDao {

	@Autowired
	private IPeopleDao ipd;
	
	@Test
	public void testSaveOrUpdate() {
		People peop1 = new People("zhangliu","123","19935813304","141124199807010170");
		People peop2 = new People(8,"zhangliu","456","19935813304","141124199807010170");
		System.out.println(ipd.saveOrUpdate(peop2));
	}
	@Test
	public void testLogin() {
		System.out.println(ipd.login("15103467169", "456"));
	}
	@Test
	public void testDelete() {
		System.out.println(ipd.delete(8));
	}
	@Test
	public void testFindAll() {
		System.out.println(ipd.findAll(1, 10));
	}
}
