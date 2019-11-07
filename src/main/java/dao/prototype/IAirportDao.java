package dao.prototype;

import java.util.List;

import entity.Airport;
import entity.Branch;

public interface IAirportDao {
	int save(Airport airport);
	int update(Airport airport);
	int delete(String airportCode);
	List<Airport> find(String airportCode);
	List<Airport> findAll();
}
