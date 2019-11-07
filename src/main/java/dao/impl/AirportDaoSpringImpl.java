package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IAirportDao;
import entity.Admin;
import entity.Airport;


@Repository("airportDaoSpringImpl")
public class AirportDaoSpringImpl implements IAirportDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public int delete(String airportCode) {
		return jdbcTemplate.update("delete from airport where airport_code=?",
				new Object[] {airportCode});
	}


	@Override
	public int save(Airport airport) {
		return jdbcTemplate.update("insert into airport(airport_code,city,airport_name) values(?,?,?)",
				new Object[] {airport.getAirportCode(),airport.getCity(),airport.getAirportName()});
	}


	@Override
	public int update(Airport airport) {
		return jdbcTemplate.update("update airport set city=?,airport_name=? where airport_code=?",
				new Object[] {airport.getCity(),airport.getAirportName(),airport.getAirportCode()});
	}


	@Override
	public List<Airport> find(String airportCode) {
		return jdbcTemplate.query("select * from airport where airport_code=?",
				new Object[] {airportCode}, 
				new BeanPropertyRowMapper<>(Airport.class));
	}


	@Override
	public List<Airport> findAll() {
		return jdbcTemplate.query("select * from airport",
				new BeanPropertyRowMapper<>(Airport.class));
	}

}
