package dao.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/*
 * SalesDao实现类
 */
import dao.prototype.ISalesDao;
import entity.Admin;
import entity.Sales;

@Repository("salesDaoSpringImpl")
public class SalesDaoSpringImpl implements ISalesDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int saveOrUpdate(Sales sales) {
		int i=0;
		if(sales.getSalesId()==0) {
			i=jdbcTemplate.update("insert into sales(branch_id,sales_name,password,phone) values(?,?,?,?)",
					new Object[] {sales.getBranchId(),sales.getSalesName(),sales.getPassword(),sales.getPhone()});
		}else {
			i=jdbcTemplate.update("update sales set branch_id=?,sales_name=?,password=?,phone=? where sales_id=?", 
					new Object[] {sales.getBranchId(),sales.getSalesName(),sales.getPassword(),sales.getPhone(),sales.getSalesId()});
		}
		return i;
	}
	
	@Override
	public int login(String phone, String password) {
		List<Sales> result=null;
		result=jdbcTemplate.query("select * from sales where phone=? and password=?", 
				new Object[] {phone,password}, 
				new BeanPropertyRowMapper<>(Sales.class));
		if(result.size()>0) {
			return 1;
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from sales where sales_id=?",
				new Object[] {id});
	}

	

}
