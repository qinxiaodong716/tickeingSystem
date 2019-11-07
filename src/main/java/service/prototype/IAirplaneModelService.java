package service.prototype;
/*
 * 
 */
import java.util.List;

import entity.AirplaneModel;

public interface IAirplaneModelService {
	int save(AirplaneModel apm);
	int update(AirplaneModel apm);
	List<AirplaneModel> find(String model);
	List<AirplaneModel> findAll();
	int delete(String  model);
}
