package service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * SalesDao实现类
 */
import dao.prototype.ISalesDao;
import entity.Sales;
import service.prototype.ISalesService;

@Repository("salesServiceDaoImpl")
public class SalesServiceDaoImpl implements ISalesService{

	@Autowired
	private ISalesDao isd;
	@Override
	public int saveOrUpdate(Sales sales) {
		return isd.saveOrUpdate(sales);
	}
	
	@Override
	public int login(String phone, String password) {
		return isd.login(phone, password);
	}

	@Override
	public int delete(int id) {
		return isd.delete(id);
	}

	@Override
	public List<Sales> find(String phone) {
		return isd.find(phone);
	}

	

}
