package service.test;
import org.junit.Test;
/*
 * PeopService测试类
 */
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.People;
import service.prototype.IPeopleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestPeopleService {
	@Autowired
	private IPeopleService ips;
	
	@Test
	public void testSaveOrUpdate() {
		People peop = new People("qz","123","19935813304","141124199807010170");
		System.out.println(ips.saveOrUpdate(peop));
	}
	@Test
	public void testLogin() {
		System.out.println(ips.login("15103467169", "123"));
	}
	@Test
	public void testphonefind() {
		System.out.println(ips.find("19935813304"));
	}
	@Test
	public void testphonefind1() {
		System.out.println(ips.nameFind("lisi"));
	}
	
}
