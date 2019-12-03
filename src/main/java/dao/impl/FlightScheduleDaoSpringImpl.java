package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IFlightSchedulerDao;
import entity.FlightScheduler;

/*
 * FlightSchedule实现类
 */
@Repository("flightScheduleDaoSpringImpl")
public class FlightScheduleDaoSpringImpl implements IFlightSchedulerDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<FlightScheduler> findAll() {
		return jdbcTemplate.query("select fs.*,a1.airport_name 'fromAirportName',a2.airport_name 'toAirportName' " + 
				"FROM flight_scheduler fs " +
				"LEFT JOIN airport a1 "+
				"ON a1.airport_code = fs.from_city " + 
				"LEFT JOIN airport a2 " + 
				"ON a2.airport_code = fs.to_city",
				new Object[] {},
				new BeanPropertyRowMapper<>(FlightScheduler.class));
	}

	@Override
	public List<FlightScheduler> listFlightSchedulers(String fromCity, String toCity, String date) {
		return jdbcTemplate.query("select fs.* ,a1.airport_name 'from_airport_name',a2.airport_name 'to_airport_name'" + 
				"				FROM flight_scheduler fs " + 
				"				LEFT JOIN airport a1" + 
				"				on a1.airport_code = fs.from_city" + 
				"				LEFT JOIN airport a2" + 
				"				on a2.airport_code = fs.to_city" + 
				"				where from_city in (" + 
				"					select airport_code " + 
				"					from airport" + 
				"					where city = ?" + 
				"				)and to_city in ( " + 
				"					select airport_code" + 
				"					from airport " + 
				"					where city = ?" + 
				"				)and fs.start_date = ?",
				new Object[] {fromCity,toCity,date},
				new BeanPropertyRowMapper<>(FlightScheduler.class));
	}

	@Override
	public int saveOrUpdate(FlightScheduler fs) {
		return jdbcTemplate.update("insert into flight_scheduler(flight_number,start_date,end_date,from_city,to_city,departure_time,arrival_time,airplane,scheduler,sail_length,basic_price) values(?,?,?,?,?,?,?,?,?,?,?)",
				new Object[] {fs.getFlightNumber(),fs.getstartDate(),fs.getendDate(),fs.getFromCity(),fs.getToCity(),fs.getDepartureTime(),fs.getArrivalTime(),fs.getAirplane(),fs.getScheduler(),fs.getSailLength(),fs.getBasicPrice()});
	}

	@Override
	public FlightScheduler flightSchedulers(String flightNumber) {
		return jdbcTemplate.queryForObject("select fs.*,a1.airport_name 'from_airport_name',a2.airport_name 'to_airport_name' " + 
				" FROM flight_scheduler fs " + 
				" LEFT JOIN airport a1" + 
				" on a1.airport_code = fs.from_city " + 
				" LEFT JOIN airport a2 " + 
				" on a2.airport_code = fs.to_city " + 
				" where flight_number =? ",
				new Object[] {flightNumber},
				new BeanPropertyRowMapper<>(FlightScheduler.class));
	}

	@Override
	public FlightScheduler select(String flightNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String flightNumber) {
		return jdbcTemplate.update("delete from flight_scheduler where flight_number = ?",new Object[] {flightNumber});
	}

	@Override
	public int saveOrUpdate(String flightNumber, Date startDate, Date endDate, String fromCity, String toCity,
			Date departureTime, Date arrivalTime, String scheduler, double sailLength, double basicPrice) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
