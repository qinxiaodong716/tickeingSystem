package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Branch;
import entity.FlightScheduler;
import entity.People;
import entity.Sales;
import service.prototype.IBranchService;
import service.prototype.IFlightSchedulerService;
import service.prototype.IPeopleService;
import service.prototype.ISalesService;

/**
 * AdminController
 * @author windows
 *
 */
@Controller
public class AdminController {
	@Autowired
	private IFlightSchedulerService iFlightSchedulerService;
	@Autowired
	private ISalesService iss;
	@Autowired
	private IBranchService ibs;
	@Autowired
	private IPeopleService ips;
	//航班管理页面
	@RequestMapping("flightmanagement")
	public ModelAndView findAllflightmanagement() {
		ModelAndView modelAndView = new ModelAndView("admin/flightmanagement");
		List<FlightScheduler> findAll = iFlightSchedulerService.findAll();
		modelAndView.addObject("findAll",findAll);
		System.out.println(findAll);
		return modelAndView;
	}
	@RequestMapping("Aindex")
	public String index() {
		return "index";
	}
	@RequestMapping("Alogin")
	public String login() {
		return "login";
	}
	@RequestMapping("HomePage")
	public String HomePage() {
		return "admin/HomePage";
	}
	//营业员页面
	@RequestMapping("adminsales")
	public ModelAndView findAlladminsales() {
		ModelAndView modelAndView = new ModelAndView("admin/sales");
		List<Sales> findAll = iss.findAll();
		modelAndView.addObject("findAll",findAll);
		return modelAndView;
	}
	//站点页面
	@RequestMapping("adminbranch")
	public ModelAndView findAllbranch() {
		ModelAndView modelAndView = new ModelAndView("admin/branch");
		List<Branch> findAll = ibs.findAll();
		modelAndView.addObject("findAll",findAll);
		return modelAndView;
	}
	//用户信息页面
	@RequestMapping("adminpeople")
	public ModelAndView findAllpeople() {
		ModelAndView modelAndView = new ModelAndView("admin/people");
		List<People> findAll = ips.findAll();
		modelAndView.addObject("findAll",findAll);
		return modelAndView;
	}
	//插入一条营业员信息
	@RequestMapping("insertsales")
	public ModelAndView insertsales(HttpServletRequest request) {
		String salesName = request.getParameter("salesName");
		int branchId = Integer.parseInt(request.getParameter("branchId"));
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		Sales sales = new Sales(branchId, salesName, password, phone);
		ModelAndView modelAndView = new ModelAndView("admin/sales");
		List<Sales> findAll = iss.findAll();
		modelAndView.addObject("findAll",findAll);
		if(iss.saveOrUpdate(sales)<1) {
			modelAndView.addObject("start","300");
		}else {
			modelAndView.addObject("start","200");
		}
		return modelAndView;
		
	}
	//插入一条站点信息
	@RequestMapping("savebranch")
	public ModelAndView savebranch(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String branchName = request.getParameter("branchName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		Branch branch = new Branch(branchName, address, telephone, province, city);
		System.out.println(branchName);
		ModelAndView modelAndView = new ModelAndView("admin/branch");
		List<Branch> findAll = ibs.findAll();
		if(ibs.saveOrUpdate(branch)<0) {
			modelAndView.addObject("start","300");
		}else {
			modelAndView.addObject("start","200");
		}
		modelAndView.addObject("findAll",findAll);
		return modelAndView;
		
	}
}