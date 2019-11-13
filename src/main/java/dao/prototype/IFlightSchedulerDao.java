package dao.prototype;

import java.util.Date;
import java.util.List;

import entity.FlightScheduler;

public interface IFlightSchedulerDao {
	//*根据flight_number查找信息
	FlightScheduler select(String flightNumber);
	//*查询所有信息
	List<FlightScheduler> find(int offset,int pageSize);
	//*添加或修改信息
	int saveOrUpdate(FlightScheduler flightScheduler);
	//*删除信息
	int delete(String flightNumber);
	int saveOrUpdate(String flightNumber, Date startDate, Date endDate, String fromCity, String toCity,
			Date departureTime, Date arrivalTime, String scheduler, double sailLength, double basicPrice);
}
