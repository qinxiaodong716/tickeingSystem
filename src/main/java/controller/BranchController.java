package controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.Branch;
import service.prototype.IBranchService;

/*
 * BranchController实现
 */
@Controller
public class BranchController {
	
	@Autowired
	private IBranchService ibs;
	
	/*@RequestMapping("branch/{pageNo}/{pageSize}")
	@ResponseBody
	public String getBranch(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize) {
		List<Branch> branch = ibs.findAll();
		return "123";
		//return JSON.toJSONString(branch);
	}*/
	
	@RequestMapping("/branch")
	@ResponseBody
	public String Branch() {
		List<Branch> branch = ibs.findAll();
		return JSON.toJSONString(branch);
	}
	//删除一条站点
	@GetMapping("/deletebranch/{branchId}")
	public ModelAndView deletebranch(@PathVariable("branchId") int branchId) {
		ibs.delete(branchId);
		ModelAndView modelAndView = new ModelAndView("admin/branch");
		List<Branch> findAll = ibs.findAll();
		modelAndView.addObject("findAll",findAll);
		return modelAndView;
	}
	
}
