package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Branch;
import entity.FlightScheduler;
import service.prototype.IFlightSchedulerService;




@Controller
public class FlightSchedulerController {
	
	@Autowired
	private IFlightSchedulerService ifss;
	//查询航向信息
	@RequestMapping("/inquireflight")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("people/inquireflight");
		String fromCity = request.getParameter("fromCity");
		String toCity = request.getParameter("toCity");
		String date = request.getParameter("startDate");
		System.out.println(fromCity);
		System.out.println(toCity);
		System.out.println(date);
		List<FlightScheduler> acts = ifss.listFlightSchedulers(fromCity,toCity,date);
		mv.addObject("acts",acts);
		return mv;
	}
	//查询航班信息
	@RequestMapping("/buyticket/{flightNumber}")
	public ModelAndView checkFlights(@PathVariable String flightNumber, HttpSession session,HttpServletResponse response) {
		if("yes".equals(session.getAttribute("login"))) {
			ModelAndView mv = new ModelAndView("people/buyticket");
			List<FlightScheduler> acts = ifss.listFlightSchedulers(flightNumber);
			mv.addObject("acts",acts);
			return mv;
		}else {
			
			try {
				response.sendRedirect("login");
			} catch (IOException e) {
				e.printStackTrace();
			}
			ModelAndView mv = new ModelAndView();
			mv.addObject("tishi","请先登录");
			return mv;
		}
	}
	@RequestMapping("/saveflightscheduler")
	public ModelAndView saveflightscheduler(HttpServletRequest request) {
		String flightNumber = request.getParameter("flightNumber");    //航班号
		String startDate = request.getParameter("startDate");			//开始日期
		String endDate = request.getParameter("endDate");			//结束日期
		String fromCity = request.getParameter("fromCity");		//出发地机场
		String toCity = request.getParameter("toCity");			//到达地机场
		String departureTime = request.getParameter("departureTime");		//离港时间
		String arrivalTime = request.getParameter("arrivalTime");	//到港时间
		String airplane = request.getParameter("airplane");		//执行机型
		String scheduler = request.getParameter("scheduler");		//班期
		int sailLength = Integer.parseInt(request.getParameter("sailLength"));			//航程
		double basicPrice = Double.parseDouble(request.getParameter("basicPrice"));	
		FlightScheduler fs = new FlightScheduler(flightNumber, startDate, endDate, fromCity, toCity, departureTime, arrivalTime, airplane, scheduler, sailLength, basicPrice);
		ifss.saveOrUpdate(fs);
		ModelAndView modelAndView = new ModelAndView("admin/flightmanagement");
		List<FlightScheduler> findAll = ifss.findAll();
		modelAndView.addObject("findAll",findAll);
		System.out.println(findAll);
		return modelAndView;
	}
	//删除一条航班信息
		@GetMapping("/deleteflightscheduler/{id}")
		public ModelAndView deletebranch(@PathVariable("id") String id) {
			ifss.delete(id);
			ModelAndView modelAndView = new ModelAndView("admin/flightmanagement");
			List<FlightScheduler> findAll = ifss.findAll();
			modelAndView.addObject("findAll",findAll);
			System.out.println(findAll);
			return modelAndView;
		}
}
