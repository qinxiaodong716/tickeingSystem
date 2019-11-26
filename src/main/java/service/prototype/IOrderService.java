package service.prototype;

import java.util.List;

import entity.Order;

public interface IOrderService {
	long save(Order order);
	List<Order> find(long id);
	List<Order> find(String phone);
}
