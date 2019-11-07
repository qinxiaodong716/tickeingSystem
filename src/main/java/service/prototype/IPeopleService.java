package service.prototype;

import entity.People;

/*
 * people业务接口
 */
public interface IPeopleService {
	int saveOrUpdate(People peop);
	int login(String phone,String password);
}
