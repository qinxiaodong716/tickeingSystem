package Dao.test;
/*
 * 管理者类测试
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IAdminDao;
import entity.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestAdminDao {

	@Autowired
	private IAdminDao iad;
	
	@Test
	public void testSaveOrUpdate() {
		Admin admin = new Admin(4,"wangwu", "123", 1,"15103467169");
		System.out.println(iad.saveOrUpdate(admin));
	}
	
	@Test
	public void testLogin() {
		System.out.println(iad.login("15103467169", "123"));
	}
	
	@Test
	public void testDelete() {
		System.out.println(iad.delete(6));
	}
	
}