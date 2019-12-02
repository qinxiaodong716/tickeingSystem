package service.prototype;

import java.util.List;

import entity.Airport;
import entity.Branch;

public interface IAirportService {
	int save(Airport airport);
	int update(Airport airport);
	int delete(String airportCode);
	Airport find(String airportCode);
	List<Airport> findAll();
}
