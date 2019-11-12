package service.prototype;
import java.util.List;

/*
 * SalesDao实现类
 */
import entity.Sales;

public interface ISalesService {
	int saveOrUpdate(Sales sales);
	int login(String phone,String password);
	int delete(int id);
	List<Sales> find(String phone);
}
