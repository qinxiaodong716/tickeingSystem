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
	/*
	 * 注册用户
	 */
	@Override
	public int saveOrUpdate(People peop) {
		int i=0;
		if(peop.getPeopleId()==0) {
			i=jdbcTemplate.update("insert into people(people_name,password,phone,id_card) values(?,?,?,?)",
					new Object[] {peop.getPeopleName(),peop.getPassword(),peop.getPhone(),peop.getIdCard()});
		}else {
			if(peop.getPassword()==null){
				i=jdbcTemplate.update("update people set people_name=?,phone=?,id_card=? where people_id=?", 
						new Object[] {peop.getPeopleName(),peop.getPhone(),peop.getIdCard(),peop.getPeopleId()});
			}else {
				i=jdbcTemplate.update("update people set password=?where people_id=?", 
					new Object[] {peop.getPassword(),peop.getPeopleId()});
			}
		}
		return i;
	}
	/**
	 * 验证登录
	 */
	@Override
	public List<People> login(String phone, String password){
		List<People> result=null;
		result=jdbcTemplate.query("select phone from people where phone=? and password=?", 
				new Object[] {phone,password}, 
				new BeanPropertyRowMapper<>(People.class));
		if(result.size()>0) {
			return result;
		}
		return result;
	}
	/**
	 * 删除某用户
	 */
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from people where people_id=?",
				new Object[] {id});
	}
	/**
	 * 分页查询所有用户
	 */
	@Override
	public List<People> findAll() {
		return jdbcTemplate.query("select * from people ",
				new Object[] {},
				new BeanPropertyRowMapper<People>(People.class));
	}
	/*
	 * 按手机号查询用户
	 */
	@Override
	public People find(String phone) {
		return jdbcTemplate.queryForObject("select people_id,phone,people_name,id_card from people where phone=?", 
				new Object[] {phone}, 
				new BeanPropertyRowMapper<People>(People.class));
	}
	/*
	 * 修改密码
	 */
	@Override
	public int setpassword(String phone, String password) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<People> nameFind(String name) {
		List<People> result=null;
		result=jdbcTemplate.query("select people_id,phone,people_name,id_card from people where people_name=?", 
				new Object[] {name}, 
				new BeanPropertyRowMapper<>(People.class));
		if(result.size()>0) {
			return result;
		}
		return result;
	}
}
