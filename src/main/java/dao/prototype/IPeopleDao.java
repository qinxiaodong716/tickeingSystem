package dao.prototype;

import java.util.List;

import entity.People;

public interface IPeopleDao {
	int saveOrUpdate(People peop);
	int login(String phone,String password);
	int delete(int id);
	List<People> findAll(int offset,int pageSize);
}
