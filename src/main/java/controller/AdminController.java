package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.FlightScheduler;
import service.prototype.IFlightSchedulerService;

/**
 * AdminController
 * @author windows
 *
 */
@Controller
public class AdminController {
	@Autowired
	private IFlightSchedulerService iFlightSchedulerService;
	
	@RequestMapping("FlightManagement")
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView("FlightManagement");
		List<FlightScheduler> findAll = iFlightSchedulerService.listFlightSchedulers(1, 10);
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
		return "HomePage";
	}
}