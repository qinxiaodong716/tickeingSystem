package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.prototype.IFlightDao;
import dao.prototype.IOrderDao;
import dao.prototype.ITicketOrderDao;
import entity.TicketOrder;
import service.prototype.ITicketOrderService;

/*
 * TicketOrder实现类
 */
@Repository("ticketOrderServiceDaoImpl")
public class TicketOrderServiceDaoImpl implements ITicketOrderService{

	@Autowired
	private  ITicketOrderDao itd;
	@Autowired
	private IFlightDao ifd;
	@Autowired
	private IOrderDao iod;
	@Override
	public int saveOrUpdate(TicketOrder ticketOrder) {
		/*
		 * 对接票务的数量增加减少
		 */
		iod.updata(ticketOrder.getOrderId(), "yfk");
		ifd.operation(ticketOrder.getFlightId(), "td","gp");
		return itd.saveOrUpdate(ticketOrder);
	}

	@Override
	public int delete(int id) {
		return itd.delete(id);
	}

}
