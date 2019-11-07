package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IPeopleDao;
import entity.People;

@Repository("peopleDaoSpringImpl")
public class PeopleDaoSpringImpl implements IPeopleDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int saveOrUpdate(People peop) {
		int i=0;
		if(peop.getPeopleId()==0) {
			i=jdbcTemplate.update("insert into people(people_name,password,phone,id_card) values(?,?,?,?)",
					new Object[] {peop.getPeopleName(),peop.getPassword(),peop.getPhone(),peop.getIdCard()});
		}else {
			i=jdbcTemplate.update("update people set people_name=?,password=?,phone=?,id_card=? where people_id=?", 
					new Object[] {peop.getPeopleName(),peop.getPassword(),peop.getPhone(),peop.getIdCard(),peop.getPeopleId()});
		}
		return i;
	}
	@Override
	public int login(String phone, String password){
		List<People> result=null;
		result=jdbcTemplate.query("select * from people where phone=? and password=?", 
				new Object[] {phone,password}, 
				new BeanPropertyRowMapper<>(People.class));
		if(result.size()>0) {
			return 1;
		}
		return 0;
	}
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from people where people_id=?",
				new Object[] {id});
	}

}
