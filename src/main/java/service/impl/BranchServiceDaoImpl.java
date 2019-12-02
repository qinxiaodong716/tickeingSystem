package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IBranchDao;
import entity.Branch;
import service.prototype.IBranchService;

/*
 * Branch业务实现类
 */

@Service("branchServiceDaoImpl")
public class BranchServiceDaoImpl implements IBranchService{

	@Autowired
	private IBranchDao ibd;
	@Override
	public int saveOrUpdate(Branch branch) {
		return ibd.saveOrUpdate(branch);
	}

	@Override
	public int delete(int id) {
		return ibd.delete(id);
	}

	@Override
	public Branch find(int id) {
		return ibd.find(id);
	}

	@Override
	public List<Branch> findAll() {
		return ibd.findAll();
	}

	@Override
	public List<Branch> find(String branchName) {
		return ibd.find(branchName);
	}

}
