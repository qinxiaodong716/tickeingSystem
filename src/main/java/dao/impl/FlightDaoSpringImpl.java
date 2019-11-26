package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IFlightDao;
import entity.Flight;

@Repository("flightDaoImpl")
public class FlightDaoSpringImpl implements IFlightDao{
	
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
	
	@Override
	public List<Flight> listFlight(String flightNumber, String date) {
		return jdbcTemplate.query("select flight_id from flight f where f.flight_number = ? and f.departure_date = ?", 
				new Object[] {flightNumber,date},
				new BeanPropertyRowMapper<>(Flight.class));
	}

	@Override
	public int operation(int flightId, String operation, String tp) {
		int i = 0;
		if("td".equals(operation)) {
			if("gp".equals(tp)) {
				i = jdbcTemplate.update("update flight set first_class_remain_seats = first_class_remain_seats-1 where flight_id=?", 
						new Object[] {flightId});
			}else {
				i = jdbcTemplate.update("update flight set first_class_remain_seats = first_class_remain_seats+1 where flight_id=?", 
						new Object[] {flightId});
			}
		}else if("sw".equals(operation)){
			if("gp".equals(tp)) {
				i = jdbcTemplate.update("update flight set business_class_remain_seats = business_class_remain_seats-1 where flight_id=?", 
						new Object[] {flightId});
			}else {
				i = jdbcTemplate.update("update flight set business_class_remain_seats = business_class_remain_seats+1 where flight_id=?", 
						new Object[] {flightId});
			}
		}else {
			if("gp".equals(tp)) {
				i = jdbcTemplate.update("update flight set economy_class_remain_seats = economy_class_remain_seats-1 where flight_id=?", 
						new Object[] {flightId});
			}else {
				i = jdbcTemplate.update("update flight set economy_class_remain_seats = economy_class_remain_seats+1 where flight_id=?", 
						new Object[] {flightId});
			}
		}
		return i;
	}

}
