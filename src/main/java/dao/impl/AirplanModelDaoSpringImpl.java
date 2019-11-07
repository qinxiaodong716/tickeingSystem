package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IAirplaneModelDao;
import entity.Admin;
import entity.AirplaneModel;
import util.Pager;

/*
 * AirplanModel实现类
 */
@Repository("airplanModelDaoSpringImpl")
public class AirplanModelDaoSpringImpl implements IAirplaneModelDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int save(AirplaneModel apm) {
		return jdbcTemplate.update("insert into airplane_model (model,max_sail_length,first_class_seats,business_class_seats,economy_class_seats) values(?,?,?,?,?)",
				new Object[] {apm.getModel(),apm.getMaxSailLength(),apm.getFirstClassSeats(),apm.getBusinessClassSeats(),apm.getEconomyClassSeats()});
	}

	@Override
	public int update(AirplaneModel apm) {
		return jdbcTemplate.update("update airplane_model set max_sail_length=?,first_class_seats=?,business_class_seats=?,economy_class_seats=? where model=?",
				new Object[] {apm.getMaxSailLength(),apm.getFirstClassSeats(),apm.getBusinessClassSeats(),apm.getEconomyClassSeats(),apm.getModel()});
	}

	@Override
	public List<AirplaneModel> find(String model) {
		return jdbcTemplate.query("select * from airplane_model where model=?",
				new Object[] {model},
				new BeanPropertyRowMapper<>(AirplaneModel.class));
	}

	@Override
	public List<AirplaneModel> findAll() {
		return jdbcTemplate.query("select * from airplane_model",
				new BeanPropertyRowMapper<>(AirplaneModel.class));
	}

	@Override
	public int delete(String model) {
		return jdbcTemplate.update("delete from airplane_model where model=?",
				new Object[] {model});
	}


	

}
