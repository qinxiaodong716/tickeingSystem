package service.test;

import org.junit.Test;

/*
 * AdminService测试类
 */

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import entity.Admin;
import service.prototype.IAdminService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestAdminService {
	@Autowired
	private IAdminService ias;
	@Test
	public void testSaveOrUpdate() {
		Admin admin = new Admin("qz", "123", 1,"15103467169");
		System.out.println(ias.saveOrUpdate(admin));
	}
	
	@Test
	public void testLogin() {
		System.out.println(ias.login("15103467169", "123"));
	}
}
