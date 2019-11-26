package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IAirplaneModelDao;
import dao.prototype.IFlightDao;
import dao.prototype.IFlightSchedulerDao;
import entity.AirplaneModel;
import entity.Flight;
import entity.FlightScheduler;
import service.prototype.IFlightSchedulerService;

@Service
public class FlightSchedulerServiceDaoImpl implements IFlightSchedulerService{

	@Autowired
	private IFlightSchedulerDao flightSchedulerDao;
	@Autowired
	private IFlightDao ifd;
	@Autowired
	private IAirplaneModelDao iamd;

	

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

	@Override
	public List<FlightScheduler> findAll() {
		return flightSchedulerDao.findAll();
	}

	@Override
	public int saveOrUpdate(FlightScheduler flightScheduler) {
		String flightNumber = flightScheduler.getFlightNumber();//航班号
		String departureDate = flightScheduler.getstartDate();//出发日期
		String airplane = flightScheduler.getAirplane();//机型
		//根据机型获取此航班表的座位数
		AirplaneModel apms = iamd.find(airplane);
		int firstClassRemainSeats = apms.getFirstClassSeats();//头等舱
		int businessClassRemainSeats = apms.getBusinessClassSeats();//公务舱
		int economyClassRemainSeats = apms.getEconomyClassSeats();//经济舱
		double seasonDiscount = 1;
		Flight flight = new Flight(flightNumber, departureDate, firstClassRemainSeats, businessClassRemainSeats, economyClassRemainSeats, seasonDiscount);
		//将此航班的信息写入到航班表
		ifd.saveOrUpdate(flight);
		return flightSchedulerDao.saveOrUpdate(flightScheduler);
	}

	@Override
	public List<FlightScheduler> listFlightSchedulers(String flightNumber) {
		return flightSchedulerDao.listFlightSchedulers(flightNumber);
	}
	@Override
	public List<FlightScheduler> listFlightSchedulers(String fromCity, String toCity, String date) {
		return flightSchedulerDao.listFlightSchedulers(fromCity, toCity, date);
	}

	@Override
	public List<FlightScheduler> listFlightSchedulers(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightScheduler> listFlightSchedulers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
