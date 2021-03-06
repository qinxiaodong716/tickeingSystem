package service.prototype;

import java.util.List;

import entity.Flight;

/**
 * 业务接口
 * @author windows
 *
 */
public interface IFlightService {
	
	List<Flight> listFlight(int pageNo,int pageSize);
	List<Flight> listFlight(String flightNumber,String date);
	int saveOrUpdate(Flight flight);
	int delete(int flightid);
}
