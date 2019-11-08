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
		if(ticketOrder.getticketOrderId()==0) {
			i=jdbcTemplate.update("insert into ticket_order(flight_id,passenger_name,certification_number,order_date,level,passenger_type,branch_id,sales_id) values(?,?,?,?,?,?,?,?)",
					new Object[] {ticketOrder.getflightId(),ticketOrder.getpassengerName(),ticketOrder.getcertificationNumber(),ticketOrder.getorderDate(),ticketOrder.getLevel(),ticketOrder.getpassengerType(),ticketOrder.getbranchId(),ticketOrder.getsalesId()});
		}else {
			i=jdbcTemplate.update("update ticket_order set flight_id=?,passenger_name=?,certification_number=?,order_date=?,level=?,passenger_type=?,branch_id=?,sales_id=? where ticket_order_id=?", 
					new Object[] {ticketOrder.getflightId(),ticketOrder.getpassengerName(),ticketOrder.getcertificationNumber(),ticketOrder.getorderDate(),ticketOrder.getLevel(),ticketOrder.getpassengerType(),ticketOrder.getbranchId(),ticketOrder.getsalesId(),ticketOrder.getticketOrderId()});
		}
		return i;
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from ticket_order where ticket_order_id=?",
				new Object[] {id});
	}

}
