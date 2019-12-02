package service.prototype;

import java.util.List;

import entity.Order;

public interface IOrderService {
	long save(Order order);
	Order find(long id);
	List<Order> find(String phone);
	int updata(long orderId, String status);
}
