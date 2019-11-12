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
				new Object[] {order.getTicketOrderId(),order.getPrice(),order.getStatus(),order.getFlightNumber(),order.getSalesName()});
	}

	@Override
	public List<Order> find(int id) {
		return jdbcTemplate.query("select o.order_id ,o.price,o.status,s.sales_name," +   //3
				" f.flight_id,f.flight_number,f.departure_date," +        //3
				" t.ticket_order_id,t.passenger_name,t.certification_number," +  //3
				" t.order_date, t.level,t.passenger_type,t.branch_id," + //4
				" fs.from_city, fs.to_city,fs.departure_time," + //3
				" fs.arrival_time,fs.sail_length,fs.airplane,"+  //3
				" a1.city 'from_Name',a2.city 'to_Name',b.branch_name" +  //3
				"from orders o " + 
				"JOIN ticket_order t " + 
				"on o.ticket_order_id = t.ticket_order_id " + 
				"JOIN flight f " + 
				"on o.flight_number = f.flight_number " + 
				"JOIN flight_scheduler fs " + 
				"on f.flight_number = fs.flight_number " + 
				"JOIN airport a1 " +
				"on a1.airport_code = fs.from_city " +
				"JOIN airport a2 " +
				"on a2.airport_code = fs.to_city " +
				"join branch b " +
				"on b.branch_id = t.branch_id " +
				"join sales s " +
				"on s.sales_id = t.sales_id " +
				"where order_id=?",
				new Object[] {id},
				new BeanPropertyRowMapper<>(Order.class));
	}

	@Override
	public List<Order> find(String phone) {
		return jdbcTemplate.query("select o.order_id,o.price,o.status,s.sales_name,"+   //3
				"f.flight_id,f.flight_number,f.departure_date," +        //3
				"t.ticket_order_id,t.passenger_name,t.certification_number," +  //3
				"t.order_date, t.level,t.passenger_type,t.branch_id," + //4
				"fs.from_city, fs.to_city,fs.departure_time," + //3
				"fs.arrival_time,fs.sail_length,fs.airplane,"+  //3
				"a1.city 'from_Name',a2.city 'to_Name',b.branch_name "+  //3
				"from orders o "+ 
				"JOIN ticket_order t "+ 
				"on o.ticket_order_id = t.ticket_order_id "+ 
				"JOIN flight f " + 
				"on o.flight_number = f.flight_number "+ 
				"JOIN flight_scheduler fs "+ 
				"on f.flight_number = fs.flight_number "+ 
				"JOIN airport a1 " +
				"on a1.airport_code = fs.from_city "+
				"JOIN airport a2 " +
				"on a2.airport_code = fs.to_city "+
				"join branch b " +
				"on b.branch_id = t.branch_id "+
				"join sales s " +
				"on s.sales_id = t.sales_id " +
				"where operator_phone=?",
				new Object[] {phone},
				new BeanPropertyRowMapper<>(Order.class));
	}
	
	

}
