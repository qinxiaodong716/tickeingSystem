package service.prototype;

import java.util.List;

import entity.Branch;

/*
 * BranchDao实体类Dao接口
 */

public interface IBranchService {
	int saveOrUpdate(Branch branch);
	int delete(int id);
	Branch find(int id);
	List<Branch> find(String branchName);
	List<Branch> findAll();
}
