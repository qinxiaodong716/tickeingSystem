package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.AirplaneModel;
import entity.Airport;
import entity.Branch;
import entity.FlightScheduler;
import entity.People;
import entity.Sales;
import service.prototype.IAirplaneModelService;
import service.prototype.IAirportService;
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
	private IFlightSchedulerService ifss;
	@Autowired
	private ISalesService iss;
	@Autowired
	private IBranchService ibs;
	@Autowired
	private IPeopleService ips;
	@Autowired
	private IAirplaneModelService iams;
	@Autowired
	private IAirportService ias;
	//航班管理页面
	@RequestMapping("flightmanagement")
	public ModelAndView findAllflightmanagement() {
		ModelAndView modelAndView = new ModelAndView("admin/flightmanagement");
		List<FlightScheduler> findAll = ifss.findAll();
		modelAndView.addObject("findAll",findAll);
		return modelAndView;
	}
	//获取某条航班信息
	@RequestMapping("flightNumberfind")
	public ModelAndView flightNamefind(HttpServletRequest request) {
		String flightNumber = request.getParameter("flightNumber");
		ModelAndView modelAndView = new ModelAndView("admin/flightmanagement");
		FlightScheduler flightSchedulers = ifss.flightSchedulers(flightNumber);
		modelAndView.addObject("find",flightSchedulers);
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
	//机场信息页面
	@RequestMapping("airport")
	public ModelAndView airport() {
		ModelAndView modelAndView = new ModelAndView("admin/airport");
		List<Airport> findAll = ias.findAll();
		modelAndView.addObject("findAll",findAll);
		return modelAndView;
	}
	//飞机信息页面
	@RequestMapping("airportmodel")
	public ModelAndView airportmodel() {
		ModelAndView modelAndView = new ModelAndView("admin/airplanemodel");
		List<AirplaneModel> findAll = iams.findAll();
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
		int i = iss.saveOrUpdate(sales);
		ModelAndView modelAndView = new ModelAndView("admin/sales");
		List<Sales> findAll = iss.findAll();
		modelAndView.addObject("findAll",findAll);
		if(i<1) {
			modelAndView.addObject("start","300");
		}else {
			modelAndView.addObject("start","200");
		}
		return modelAndView;
	}
	
	//插入一条站点信息
	@RequestMapping("savebranch")
	public ModelAndView savebranch(HttpServletRequest request) {
		String branchName = request.getParameter("branchName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		Branch branch = new Branch(branchName, address, telephone, province, city);
		int i = ibs.saveOrUpdate(branch);
		ModelAndView modelAndView = new ModelAndView("admin/branch");
		List<Branch> findAll = ibs.findAll();
		if(i<0) {
			modelAndView.addObject("start","300");
		}else {
			modelAndView.addObject("start","200");
		}
		modelAndView.addObject("findAll",findAll);
		return modelAndView;	
	}
	//插入飞机信息
	@RequestMapping("saveairportmodel")
	public ModelAndView saveairportmodel(HttpServletRequest request) {
		//获取飞机信息
		String model = request.getParameter("model");
		int maxSailLength = Integer.parseInt(request.getParameter("maxSailLength"));
		int firstClassSeats = Integer.parseInt(request.getParameter("firstClassSeats"));
		int businessClassSeats = Integer.parseInt(request.getParameter("businessClassSeats"));
		int economyClassSeats = Integer.parseInt(request.getParameter("economyClassSeats"));
		AirplaneModel airplaneModel = new AirplaneModel(model, maxSailLength, firstClassSeats, businessClassSeats, economyClassSeats);
		//持久化
		iams.save(airplaneModel);
		//返回插入后的飞机信息
		ModelAndView modelAndView = new ModelAndView("admin/airplanemodel");
		List<AirplaneModel> findAll = iams.findAll();
		modelAndView.addObject("findAll",findAll);
		return modelAndView;
	}
	//删除一条飞机信息
	@GetMapping("/deleteairportmodel/{model}")
	public ModelAndView deleteairportmodel(@PathVariable("model") String model) {
		iams.delete(model);
		ModelAndView modelAndView = new ModelAndView("admin/airplanemodel");
		List<AirplaneModel> findAll = iams.findAll();
		modelAndView.addObject("findAll",findAll);
		return modelAndView;
	}
	//插入一条机场信息
	@RequestMapping("saveairport")
	public ModelAndView saveairport(HttpServletRequest request) {
		String airportName = request.getParameter("airportName");
		String city = request.getParameter("city");
		String airportCode = request.getParameter("airportCode");
		Airport airport = new Airport(airportCode, city, airportName);
		ias.save(airport);
		ModelAndView modelAndView = new ModelAndView("admin/airport");
		List<Airport> findAll = ias.findAll();
		modelAndView.addObject("findAll",findAll);
		return modelAndView;
	}
	//删除一条机场信息
	@GetMapping("/deleteairport/{airportCode}")
	public ModelAndView deleteairport(@PathVariable("airportCode") String airportCode) {
		ias.delete(airportCode);
		ModelAndView modelAndView = new ModelAndView("admin/airport");
		List<Airport> findAll = ias.findAll();
		modelAndView.addObject("findAll",findAll);
		return modelAndView;
	}
	//获取所有机型
	@RequestMapping("findAllAirplane")
	@ResponseBody
	public String findAllAirplane() {
		List<AirplaneModel> findAll = iams.findAll();
		return JSON.toJSONString(findAll);
	}
	//获取所有站点
	@RequestMapping(value = "findAllSales" ,produces = {"application/text;charset=UTF-8"})
	@ResponseBody
	public String findAllSales() {
		List<Branch> findAll = ibs.findAll();
		System.out.println(findAll);
		return JSON.toJSONString(findAll);
	}
	//获取某个站点
	@RequestMapping(value = "adminfindBranch" ,produces = {"application/text;charset=UTF-8"})
	public ModelAndView adminfindBranch(HttpServletRequest request) {
		int branchId = Integer.parseInt(request.getParameter("branchId"));
		ModelAndView modelAndView = new ModelAndView("admin/branch");
		Branch find = ibs.find(branchId);
		modelAndView.addObject("find",find);
		return modelAndView;
	}
	//获取所有机场
	@RequestMapping(value ="findAllAirport" ,produces = {"application/text;charset=UTF-8"})
	@ResponseBody
	public String findAllAirport() {
		List<Airport> findAll = ias.findAll();
		return JSON.toJSONString(findAll);
	}
	//获取某个营业员
	@PostMapping(value ="IdfindSales" ,produces = {"application/text;charset=UTF-8"})
	@ResponseBody
	public String IdfindSales(String phone) {
		Sales findAll = iss.find(phone);
		return JSON.toJSONString(findAll);
	}
	//获取某个营业员
	@PostMapping(value ="adminfindSales" ,produces = {"application/text;charset=UTF-8"})
	public ModelAndView adminfindSales(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/sales");
		String phone = request.getParameter("phone");
		Sales find = iss.find(phone);
		modelAndView.addObject("find",find);
		return modelAndView;
	}
	//获取某个用户
	@PostMapping(value ="adminfindpeople" ,produces = {"application/text;charset=UTF-8"})
	public ModelAndView adminfindpeople(HttpServletRequest request) {
		String phone = request.getParameter("phone");
		System.out.println(phone);
		ModelAndView modelAndView = new ModelAndView("admin/people");
		People find = ips.find(phone);
		modelAndView.addObject("find",find);
		return modelAndView;
	}
	//获取某个机场信息
	@PostMapping(value ="adminfindAirport" ,produces = {"application/text;charset=UTF-8"})
	public ModelAndView adminfindAirport(HttpServletRequest request) {
		String airportCode = request.getParameter("airportCode");
		ModelAndView modelAndView = new ModelAndView("admin/airport");
		Airport find = ias.find(airportCode);
		modelAndView.addObject("find",find);
		return modelAndView;
	}
	//获取某个飞机信息
	@PostMapping(value ="adminfindAirportModel" ,produces = {"application/text;charset=UTF-8"})
	public ModelAndView adminfindAirportModel(HttpServletRequest request) {
		String model = request.getParameter("model");
		ModelAndView modelAndView = new ModelAndView("admin/airplanemodel");
		AirplaneModel find = iams.find(model);
		modelAndView.addObject("find",find);
		return modelAndView;
	}
}