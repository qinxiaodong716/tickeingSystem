package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	@Override
	public int saveOrUpdate(TicketOrder ticketOrder) {
		return itd.saveOrUpdate(ticketOrder);
	}

	@Override
	public int delete(int id) {
		return itd.delete(id);
	}

}
