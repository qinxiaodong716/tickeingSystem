package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alipay.api.domain.Sale;

import config.TestConfig;
import entity.Sales;
import service.prototype.ISalesService;

/*
 * Sales测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestSalesService {
	@Autowired
	private ISalesService iss;
	
	@Test
	public void TestFindPhone() {
		System.out.println(iss.find("18406553729"));
	}
	@Test
	public void Testsave() {
		Sales sales = new Sales(20, "uio", "123", "12244445555");
		System.out.println(iss.saveOrUpdate(sales));
	}
	
}
