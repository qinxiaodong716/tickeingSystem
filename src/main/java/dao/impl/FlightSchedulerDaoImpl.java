package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IFlightSchedulerDao;
import entity.FlightScheduler;

@Repository("flightSchedulerDaoImpl")
public class FlightSchedulerDaoImpl implements IFlightSchedulerDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//*查询所有信息
	public List<FlightScheduler> find(int offset, int pageSize){
		return jdbcTemplate.query("SELECT * FROM flight_scheduler limit ?,?", 
				new Object[] {offset,pageSize},
				new BeanPropertyRowMapper<FlightScheduler>(FlightScheduler.class));
		
	}
	//*增加或修改信息
	@Override
	public int saveOrUpdate(FlightScheduler flightScheduler) {
		int i = 0;
		if(flightScheduler.getflightNumber()==null) {
			i = jdbcTemplate.update("insert into flight_scheduler(flight_number,start_date,end_date,from_city,to_city,departure_time,arrival_time,airplane,scheduler,sail_length,basic_price) values(?,?,?,?,?,?,?,?,?,?,?)",
					new Object[] {flightScheduler.getflightNumber(),flightScheduler.getStartDate(),flightScheduler.getEndDate(),flightScheduler.getFromCity(),flightScheduler.getToCity(),flightScheduler.getDepartureTime(),flightScheduler.getArrivalTime(),flightScheduler.getAirplane(),flightScheduler.getScheduler(),flightScheduler.getSailLength(),flightScheduler.getBasicPrice()});
		}else {
			i = jdbcTemplate.update("update flight_scheduler set start_date=?,end_date=?,from_city=?,to_city=?,departure_time=?,arrival_time=?,airplane=?,scheduler=?,sail_length=?,basic_price=? where flight_number=?",
					new Object[] {flightScheduler.getStartDate(),flightScheduler.getEndDate(),flightScheduler.getFromCity(),flightScheduler.getToCity(),flightScheduler.getDepartureTime(),flightScheduler.getArrivalTime(),flightScheduler.getAirplane(),flightScheduler.getScheduler(),flightScheduler.getSailLength(),flightScheduler.getBasicPrice()});
					
		}
		return i;
	}
	
	//*删除信息
	@Override
	public int delete(String flightNumber) {
		return jdbcTemplate.update("delete from flight_scheduler where flight_number=?",
				new Object[] {flightNumber});
	}
	
	//*根据flightNumber查询信息
	@Override
	public FlightScheduler select(String flightNumber) {
		return (FlightScheduler) jdbcTemplate.query("select * from flight_scheduler where flight_number=?",
				new Object[] {flightNumber},
				new BeanPropertyRowMapper<>(FlightScheduler.class));
	}
	@Override
	public int saveOrUpdate(String flightNumber, Date startDate, Date endDate, String fromCity, String toCity,
			Date departureTime, Date arrivalTime, String scheduler, double sailLength, double basicPrice) {
		// TODO Auto-generated method stub
		return 0;
	}
}
