package Dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IBranchDao;
import entity.Branch;

/*
 * BranchDao测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestBranchDao {
	@Autowired
	private IBranchDao ibd;
	
	@Test
	public void testSaveOrUpdate() {
		Branch branch = new Branch(1,"xuefu","shanxitaiyuan","400-800-5956","shanxi","taiyuan");
		System.out.println(ibd.saveOrUpdate(branch));
	}
	@Test
	public void testDelete() {
		System.out.println(ibd.delete(2));
	}
	@Test
	public void testFind() {
		System.out.println(ibd.find(2));
	}
	@Test
	public void testFindAll() {
		System.out.println(ibd.findAll());
	}
}
