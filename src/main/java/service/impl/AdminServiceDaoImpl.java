package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IAdminDao;
import entity.Admin;
import service.prototype.IAdminService;

/*
 * Admin业务实现类
 */
@Service("adminServiceDaoImpl")
public class AdminServiceDaoImpl implements IAdminService{

	@Autowired
	private IAdminDao iad;
	@Override
	public int saveOrUpdate(Admin admin) {
		return iad.saveOrUpdate(admin);
	}

	@Override
	public int login(String phone, String password) {
		return iad.login(phone, password);
	}

}
