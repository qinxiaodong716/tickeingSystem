package dao.prototype;

import java.util.List;

import entity.Order;

public interface IOrderDao {
	long save(Order order);
	List<Order> find(long id);
	int updata(long orderId,String status);
	List<Order> find(String phone);
}
