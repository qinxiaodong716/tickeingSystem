package service.prototype;

import java.util.Date;
import java.util.List;

import entity.FlightScheduler;

public interface IFlightSchedulerService {

	List<FlightScheduler> listFlightSchedulers(int pageNo,int pageSize);
	//*添加一条记录
	public boolean add(FlightScheduler flightScheduler);
	public int add(String flightNumber, Date startDate, Date endDate, String fromCity, String toCity,Date departureTime, Date arrivalTime, String scheduler, double sailLength, double basicPrice);
	//*根据flighNumber查找
	public FlightScheduler find(String flightNumber);
	//*更新
	public int update(FlightScheduler flightScheduler);
	//*删除
	public int delete(String flightNumber);
	/*
	 * FlightScheduler  业务接口
	 */

	List<FlightScheduler> findAll();
	List<FlightScheduler> listFlightSchedulers(String fromCity,String toCity,String date);
	FlightScheduler flightSchedulers(String flightNumber);
	int saveOrUpdate(FlightScheduler flightScheduler);
	List<FlightScheduler> listFlightSchedulers();
	
}
