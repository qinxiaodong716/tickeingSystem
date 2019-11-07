package dao.prototype;

import entity.People;

public interface IPeopleDao {
	int saveOrUpdate(People peop);
	int login(String phone,String password);
	int delete(int id);
}
