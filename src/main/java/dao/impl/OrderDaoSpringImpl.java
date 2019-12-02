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
	public long save(Order order) {
		jdbcTemplate.update("insert into orders(operator_phone,price,status,flight_number,operator_type,linkman_name,linkman_phone) values(?,?,?,?,?,?,?)",
				new Object[] {order.getOperatorPhone(),order.getPrice(),order.getStatus(),order.getFlightNumber(),order.getOperatorType(),order.getlinkmanName(),order.getLinkmanPhone()});
		List<Order> res = jdbcTemplate.query("select Max(order_id) 'order_id' from orders", new BeanPropertyRowMapper<>(Order.class));
		return res.get(0).getOrderId();
	}

	@Override
	public Order find(long id) {
		return jdbcTemplate.queryForObject("select o.order_id ,o.price,o.status,s.sales_name," +   //3
				" f.flight_id,f.flight_number,f.departure_date,o.linkman_phone," +        //3
				" t.ticket_order_id,t.passenger_name,t.certification_number," +  //3
				" t.order_date, t.level,t.passenger_type,t.branch_id," + //4
				" a1.airport_name 'from_airport_name', a2.airport_name 'to_airport_name',fs.departure_time," + //3
				" fs.arrival_time,fs.sail_length,fs.airplane,"+  //3
				" a1.city 'from_city',a2.city 'to_city',b.branch_name " +  //3
				"from orders o " + 
				"JOIN ticket_order t " + 
				"on o.order_id = t.order_id " + 
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
				"where o.order_id=?",
				new Object[] {id},
				new BeanPropertyRowMapper<>(Order.class));
	}

	@Override
	public List<Order> find(String phone) {
		return jdbcTemplate.query("select o.order_id,o.price,o.status,s.sales_name,"+   //3
				"f.flight_id,f.flight_number,f.departure_date,o.linkman_phone," +        //3
				"t.ticket_order_id,t.passenger_name,t.certification_number," +  //3
				"t.order_date, t.level,t.passenger_type,t.branch_id," + //4
				"a1.airport_name 'from_airport_name', a2.airport_name 'to_airport_name',fs.departure_time,fs.departure_time," + //3
				"fs.arrival_time,fs.sail_length,fs.airplane,"+  //3
				"a1.city 'from_city',a2.city 'to_city',b.branch_name "+  //3
				"from orders o "+ 
				"JOIN ticket_order t "+ 
				"on o.order_id = t.order_id "+ 
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

	@Override
	public int updata(long orderId, String status) {
		return jdbcTemplate.update("update orders set status = ? where order_id = ?",
				new Object[] {status,orderId+""});
		
	}
	
	

}
