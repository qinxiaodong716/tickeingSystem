package service.prototype;

import java.util.List;

import entity.People;

/*
 * people业务接口
 */
public interface IPeopleService {
	int saveOrUpdate(People peop);
	List<People> find(String phone);
	List<People> login(String phone,String password);
	
}
