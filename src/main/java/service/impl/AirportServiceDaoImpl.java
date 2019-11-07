package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IAirportDao;
import entity.Airport;
import service.prototype.IAirportService;

/*
 * Airport业务实现类
 */

@Service("airportServiceDaoImpl")
public class AirportServiceDaoImpl implements IAirportService{

	@Autowired
	private IAirportDao iad;
	@Override
	public int save(Airport airport) {
		return iad.save(airport);
	}

	@Override
	public int update(Airport airport) {
		return iad.update(airport);
	}

	@Override
	public int delete(String airportCode) {
		return iad.delete(airportCode);
	}

	@Override
	public List<Airport> find(String airportCode) {
		return iad.find(airportCode);
	}

	@Override
	public List<Airport> findAll() {
		return iad.findAll();
	}

}
