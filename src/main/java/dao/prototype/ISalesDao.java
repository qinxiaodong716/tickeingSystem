package dao.prototype;
/*
 * SalesDao实现类
 */
import entity.Sales;

public interface ISalesDao {
	int saveOrUpdate(Sales sales);
	int login(String phone,String password);
	int delete(int id);
}
