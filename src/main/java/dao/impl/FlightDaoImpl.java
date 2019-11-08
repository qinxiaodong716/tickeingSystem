package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IFlightDao;
import entity.Flight;

@Repository("flightDaoImpl")
public class FlightDaoImpl implements IFlightDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Flight> find(int offset, int pageSize) {
		return jdbcTemplate.query("select * from flight limit ?,?",
				new Object[] {offset,pageSize},
				new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Override
	public int saveOrUpdate(Flight flight) {
		int i = 0;
		if(flight.getFlightId()==0) {
			i = jdbcTemplate.update("insert into flight(flight_number,departure_date,first_class_remain_seats,business_class_remain_seats,economy_class_remain_seats,season_discount) values(?,?,?,?,?,?)",
					new Object[] {flight.getFlightNumber(),flight.getDepartureDate(),flight.getFirstClassRemainSeats(),flight.getBusinessClassRemainSeats(),flight.getEconomyClassRemainSeats(),flight.getSeasonDiscount()});
		}else {
			i = jdbcTemplate.update("update flight set flight_number=?,departure_date=?,first_class_remain_seats=?,business_class_remain_seats=?,economy_class_remain_seats=?,season_discount=? where flight_id=?",
					new Object[] {flight.getFlightNumber(),flight.getDepartureDate(),flight.getFirstClassRemainSeats(),flight.getBusinessClassRemainSeats(),flight.getEconomyClassRemainSeats(),flight.getSeasonDiscount(),flight.getFlightId()});
		}
		return i;
	}

	@Override
	public int delete(int flightId) {
		return jdbcTemplate.update("delete from flight where flight_id=?", 
				new Object[] {flightId});
		
	}

}
