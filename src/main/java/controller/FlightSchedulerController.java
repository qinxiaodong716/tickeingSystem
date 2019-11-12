package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Flight;
import service.prototype.IFlightService;

@Controller
public class FlightSchedulerController {
	@Autowired
	private IFlightService ifs;
	//查询航向信息
	@RequestMapping("/inquireflight")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("people/inquireflight");
		String fromCity = request.getParameter("fromCity");
		String toCity = request.getParameter("toCity");
		String date = request.getParameter("date");
		System.out.println(fromCity);
		System.out.println(toCity);
		System.out.println(date);
		List<Flight> acts = ifs.listFlightSchedulers(fromCity,toCity,date);
		mv.addObject("acts",acts);
		return mv;
	}
	//查询航班信息
	@RequestMapping("/checkflights/{flightNumber}")
	public ModelAndView checkFlights(@PathVariable String flightNumber) {
		ModelAndView mv = new ModelAndView("people/inquireflight");
		List<Flight> acts = ifs.listFlight(1, 10);
		mv.addObject("acts", acts);
		return mv;
	}
}
