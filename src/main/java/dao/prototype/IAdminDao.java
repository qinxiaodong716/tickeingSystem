package dao.prototype;

import entity.Admin;

public interface IAdminDao {
	int saveOrUpdate(Admin admin);
	int login(String phone,String password);
	int delete(int id);
}
