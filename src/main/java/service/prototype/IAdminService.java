package service.prototype;

import entity.Admin;

/*
 * Admin业务实现接口
 */
public interface IAdminService {
	int saveOrUpdate(Admin admin);
	int login(String phone,String password);
}
