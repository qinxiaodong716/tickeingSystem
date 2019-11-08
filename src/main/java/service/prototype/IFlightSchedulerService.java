package service.prototype;

import java.util.List;

import entity.FlightScheduler;
import util.MiniPager;

public interface IFlightSchedulerService {

	
	List<FlightScheduler> listFlightSchedulers(int pageNo,int pageSize);
}
