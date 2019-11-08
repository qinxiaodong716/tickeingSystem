package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IAdminDao;
import dao.prototype.IOrderDao;
import entity.Admin;
import entity.Order;

@Repository("orderDaoSpringImpl")
public class OrderDaoSpringImpl implements IOrderDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Order order) {
		int i=0;
		return i=jdbcTemplate.update("insert into orders(ticket_order_id,price,status,flight_number) values(?,?,?,?)",
				new Object[] {order.getTicketOrderId(),order.getPrice(),order.getStatus(),order.getFlightNumber()});
	}

	@Override
	public List<Order> find(int id) {
		return jdbcTemplate.query("select * from orders where order_id=?",
				new Object[] {id},
				new BeanPropertyRowMapper<>(Order.class));
	}
	
	

}
