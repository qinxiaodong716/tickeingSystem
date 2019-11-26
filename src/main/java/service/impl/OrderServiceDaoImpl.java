package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.prototype.IOrderDao;
import entity.Order;
import service.prototype.IOrderService;

@Repository("orderServiceDaoImpl")
public class OrderServiceDaoImpl implements IOrderService{
	
	@Autowired
	private IOrderDao iod;
	

	@Override
	public long save(Order order) {
		return iod.save(order);
	}

	@Override
	public List<Order> find(long id) {
		return iod.find(id);
	}

	@Override
	public List<Order> find(String phone) {
		return iod.find(phone);
	}
	
	

}
