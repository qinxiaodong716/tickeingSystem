package service.prototype;

import java.util.List;

import entity.Order;

public interface IOrderService {
	int save(Order order);
	List<Order> find(int id);
	List<Order> find(String phone);
}
