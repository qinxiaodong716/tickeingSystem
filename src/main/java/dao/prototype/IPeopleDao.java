package dao.prototype;

import java.util.List;

import entity.People;

public interface IPeopleDao {
	int saveOrUpdate(People peop);
	List<People> login(String phone,String password);
	int delete(int id);
	List<People> find(String phone);
	List<People> nameFind(String name);
	List<People> findAll();
	int setpassword(String phone,String password);
}
