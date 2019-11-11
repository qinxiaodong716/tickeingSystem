package service.prototype;
/*
 * TicketOrder接口
 */
import entity.TicketOrder;

public interface ITicketOrderService {
	int saveOrUpdate(TicketOrder ticketOrder);
	int delete(int id);
}
