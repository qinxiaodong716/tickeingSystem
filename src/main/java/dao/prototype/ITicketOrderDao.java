package dao.prototype;
/*
 * TicketOrder接口
 */
import entity.TicketOrder;

public interface ITicketOrderDao {
	int saveOrUpdate(TicketOrder ticketOrder);
	int delete(int id);
}
