package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IFlightSchedulerDao;
import entity.FlightScheduler;
import service.prototype.IFlightSchedulerService;

@Service
public class FlightSchedulerServiceDaoImpl implements IFlightSchedulerService{

	@Autowired
	private IFlightSchedulerDao flightSchedulerDao;

	@Override
	public List<FlightScheduler> listFlightSchedulers(int pageNo, int pageSize) {
		return flightSchedulerDao.find((pageNo-1)*pageSize, pageSize);
	}

	@Override
	public boolean add(FlightScheduler flightScheduler) {
		return false;
	}

	@Override
	public int add(String flightNumber, Date startDate, Date endDate, String fromCity, String toCity,
			Date departureTime, Date arrivalTime, String scheduler, double sailLength, double basicPrice) {
		return flightSchedulerDao.saveOrUpdate(flightNumber,startDate,endDate, fromCity,toCity,departureTime,arrivalTime,scheduler,sailLength,basicPrice);
	}

	@Override
	public FlightScheduler find(String flightNumber) {
		return flightSchedulerDao.select(flightNumber);
	}

	@Override
	public int update(FlightScheduler flightScheduler) {
		return flightSchedulerDao.saveOrUpdate(flightScheduler);
	}

	@Override
	public int delete(String flightNumber) {
		return flightSchedulerDao.delete(flightNumber);
	}
	
	
}
