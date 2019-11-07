package service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IBranchDao;
import entity.Branch;
import service.prototype.IBranchService;

/*
 * BranchDao测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestBranchService {
	@Autowired
	private IBranchService ibs;
	
	@Test
	public void testSaveOrUpdate() {
		Branch branch = new Branch(3,"pingyang","shanxitaiyuan","400-800-5659","shanxi","taiyuan");
		System.out.println(ibs.saveOrUpdate(branch));
	}
	@Test
	public void testDelete() {
		System.out.println(ibs.delete(2));
	}
	@Test
	public void testFind() {
		System.out.println(ibs.find(3));
	}
	@Test
	public void testFindAll() {
		System.out.println(ibs.findAll());
	}
}
