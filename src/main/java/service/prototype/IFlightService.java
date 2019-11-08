package service.prototype;

import java.util.List;

import entity.Flight;
import util.MiniPager;

/**
 * 业务接口
 * @author windows
 *
 */
public interface IFlightService {
	
	List<Flight> listFlight(int pageNo,int pageSize);
}
