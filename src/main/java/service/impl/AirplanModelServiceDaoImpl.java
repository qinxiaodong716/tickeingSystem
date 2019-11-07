package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IAirplaneModelDao;
import entity.AirplaneModel;
import service.prototype.IAirplaneModelService;

@Service("airplanModelServiceDaoImpl")
public class AirplanModelServiceDaoImpl implements IAirplaneModelService{
	
	@Autowired
	private IAirplaneModelDao iamd;
	@Override
	public int save(AirplaneModel apm) {
		return iamd.save(apm);
	}

	@Override
	public int update(AirplaneModel apm) {
		return iamd.update(apm);
	}

	@Override
	public List<AirplaneModel> find(String model) {
		return iamd.find(model);
	}

	@Override
	public List<AirplaneModel> findAll() {
		return iamd.findAll();
	}

	@Override
	public int delete(String model) {
		return iamd.delete(model);
	}

}
