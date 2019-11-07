package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IPeopleDao;
import entity.People;
import service.prototype.IPeopleService;

/*
 * people的业务实现列
 */
@Service("PeopleServiceDaoImpl")
public class PeopleServiceDaoImpl implements IPeopleService{

	@Autowired
	private IPeopleDao ipd;
	@Override
	public int saveOrUpdate(People peop) {
		return ipd.saveOrUpdate(peop);
	}

	@Override
	public int login(String phone, String password) {
		return ipd.login(phone, password);
	}
	
}
