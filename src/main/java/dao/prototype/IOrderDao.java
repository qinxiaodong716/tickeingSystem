package dao.prototype;

import java.util.List;

import entity.Order;

public interface IOrderDao {
	int save(Order order);
	List<Order> find(int id);
}
