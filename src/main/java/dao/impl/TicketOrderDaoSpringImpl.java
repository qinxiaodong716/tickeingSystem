package dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.ITicketOrderDao;
import entity.TicketOrder;

/*
 * TicketOrder实现类
 */
@Repository("ticketOrderDaoSpringImpl")
public class TicketOrderDaoSpringImpl implements ITicketOrderDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int saveOrUpdate(TicketOrder ticketOrder) {
		int i=0;
		if(ticketOrder.getTicketOrderId()==0) {
			if(ticketOrder.getSalesId()==0) {
				i = jdbcTemplate.update("insert into ticket_order(flight_id,passenger_name,certification_number,level,passenger_type,order_id) values(?,?,?,?,?,?)", 
					new Object[] {ticketOrder.getFlightId(),ticketOrder.getPassengerName(),ticketOrder.getCertificationNumber(),ticketOrder.getLevel(),ticketOrder.getPassengerType(),ticketOrder.getOrderId()});
			}else {
				i = jdbcTemplate.update("insert into ticket_order(flight_id,passenger_name,certification_number,level,passenger_type,order_id,branch_id,sales_id) values(?,?,?,?,?,?,?,?)", 
						new Object[] {ticketOrder.getFlightId(),ticketOrder.getPassengerName(),ticketOrder.getCertificationNumber(),ticketOrder.getLevel(),ticketOrder.getPassengerType(),ticketOrder.getOrderId(),ticketOrder.getBranchId(),ticketOrder.getSalesId()});
			}
			
		}else {
				i = jdbcTemplate.update("update ticket_order set flight_id=?,passenger_name=?,certification_number=?,level=?,passenger_type=?,order_id=?,branch_id=?,sales_id=? where ticket_order_id = ?", 
						new Object[] {ticketOrder.getFlightId(),ticketOrder.getPassengerName(),ticketOrder.getCertificationNumber(),ticketOrder.getLevel(),ticketOrder.getPassengerType(),ticketOrder.getOrderId(),ticketOrder.getBranchId(),ticketOrder.getSalesId(),ticketOrder.getTicketOrderId()});
						}
		return i;
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from ticket_order where ticket_order_id=?",
				new Object[] {id});
	}

}
