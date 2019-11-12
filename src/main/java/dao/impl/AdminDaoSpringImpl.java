package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IAdminDao;
import entity.Admin;

@Repository("adminDaoSpringImpl")
public class AdminDaoSpringImpl implements IAdminDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int saveOrUpdate(Admin admin) {
		int i=0;
		if(admin.getAdminId()==0) {
			i=jdbcTemplate.update("insert into admin(admin_name,password,department_id,phone) values(?,?,?,?)",
					new Object[] {admin.getAdminName(),admin.getPassword(),admin.getDepartmentId(),admin.getPhone()});
		}else {
			if(admin.getPassword()==null) {
				i=jdbcTemplate.update("update admin set admin_name=?,department_id=?,phone=? where admin_id=?", 
						new Object[] {admin.getAdminName(),admin.getPassword(),admin.getDepartmentId(),admin.getPhone(),admin.getAdminId()});
			}else {
				i=jdbcTemplate.update("update admin set password=? where admin_id=?", 
					new Object[] {admin.getPassword(),admin.getAdminId()});
			}
		}
		return i;
	}

	@Override
	public int login(String phone, String password) {
		List<Admin> result=null;
		result=jdbcTemplate.query("select * from admin where phone=? and password=?", 
				new Object[] {phone,password}, 
				new BeanPropertyRowMapper<>(Admin.class));
		if(result.size()>0) {
			return 1;  //返回所在部门id
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from admin where admin_id=?",
				new Object[] {id});
	}
	
	

}
