package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IOrderDao;
import entity.Order;

@Repository("orderDaoSpringImpl")
public class OrderDaoSpringImpl implements IOrderDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Order order) {
		return jdbcTemplate.update("insert into orders(ticket_order_id,price,status,flight_number,operator_phone) values(?,?,?,?,?)",
				new Object[] {order.getTicketOrderId(),order.getPrice(),order.getStatus(),order.getFlightNumber(),order.getOperatorPhone()});
	}

	@Override
	public List<Order> find(int id) {
		return jdbcTemplate.query("select o.order_id ,o.price,o.status,o.operator_phone," + 
				"			 f.flight_id,f.flight_number,f.departure_date," + 
				"			 t.ticket_order_id,t.passenger_name,t.certification_number," + 
				"			 t.order_date, t.level,t.passenger_type," + 
				"			 fs.from_city, fs.to_city,fs.departure_time," + 
				"			 fs.arrival_time,fs.sail_length,fs.airplane " + 
				"from orders o " + 
				"JOIN ticket_order t " + 
				"on o.ticket_order_id = t.ticket_order_id " + 
				"JOIN flight f " + 
				"on o.flight_number = f.flight_number " + 
				"JOIN flight_scheduler fs " + 
				"on f.flight_number = fs.flight_number " + 
				"where order_id=?",
				new Object[] {id},
				new BeanPropertyRowMapper<>(Order.class));
	}

	@Override
	public List<Order> find(String phone) {
		return jdbcTemplate.query("select o.order_id ,o.price,o.status,o.operator_phone," + 
				"			 f.flight_id,f.flight_number,f.departure_date," + 
				"			 t.ticket_order_id,t.passenger_name,t.certification_number," + 
				"			 t.order_date, t.level,t.passenger_type," + 
				"			 fs.from_city, fs.to_city,fs.departure_time," + 
				"			 fs.arrival_time,fs.sail_length,fs.airplane " + 
				"from orders o " + 
				"JOIN ticket_order t " + 
				"on o.ticket_order_id = t.ticket_order_id " + 
				"JOIN flight f " + 
				"on o.flight_number = f.flight_number " + 
				"JOIN flight_scheduler fs " + 
				"on f.flight_number = fs.flight_number " + 
				"where operator_phone=?",
				new Object[] {phone},
				new BeanPropertyRowMapper<>(Order.class));
	}
	
	

}
