package dao.prototype;

import java.util.List;

import entity.Flight;

/**
 * FilghtDao
 * @author windows
 *
 */
public interface IFlightDao {
	List<Flight> find(int offset,int pageSize);
	List<Flight> listFlightSchedulers(String fromCity,String toCity,String date);
	int saveOrUpdate(Flight flight);
	int delete(int flightId);
}
