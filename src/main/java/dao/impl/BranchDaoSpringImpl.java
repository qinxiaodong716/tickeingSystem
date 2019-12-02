package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IBranchDao;
import entity.Branch;


@Repository("branchDaoSpringImpl")
public class BranchDaoSpringImpl implements IBranchDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int saveOrUpdate(Branch branch) {
		if(branch.getBranchId()==0) {
			return jdbcTemplate.update("insert into branch(branch_name,address,telephone,province,city) values(?,?,?,?,?)",
					new Object[] {branch.getBranchName(),branch.getAddress(),branch.getTelephone(),branch.getProvince(),branch.getCity()});
		}else {
			return jdbcTemplate.update("update branch set branch_name=?,address=?,telephone=?,province=?,city=? where branch_id=?",
					new Object[] {branch.getBranchName(),branch.getAddress(),branch.getTelephone(),branch.getProvince(),branch.getCity(),branch.getBranchId()});
		}
		
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from branch where branch_id=?",
				new Object[] {id});
	}

	@Override
	public Branch find(int id) {
		return jdbcTemplate.queryForObject("select * from branch where branch_id=?", 
				new Object[] {id},
				new BeanPropertyRowMapper<Branch>(Branch.class));
	}

	@Override
	public List<Branch> findAll() {
		return jdbcTemplate.query("select * from branch where branch_id>0", 
				new BeanPropertyRowMapper<Branch>(Branch.class));
	}

	@Override
	public List<Branch> find(String branchName) {
		return jdbcTemplate.query("select * from branch where branch_name=?", 
				new Object[] {branchName},
				new BeanPropertyRowMapper<Branch>(Branch.class));
	}

}
