package controller;
/*
 * 订单Cotroller
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.FlightScheduler;
import entity.Order;
import entity.TicketOrder;
import service.prototype.IFlightSchedulerService;
import service.prototype.IFlightService;
import service.prototype.IOrderService;
import service.prototype.ITicketOrderService;

@Controller
public class OrderController {
	
	@Autowired
	private IOrderService ios;
	@Autowired
	private IFlightSchedulerService ifss;
	@Autowired
	private ITicketOrderService itos;
	@Autowired
	private IFlightService ifs;
	//使用手机号查询订单信息
	@RequestMapping("/orderinquiry")
	public ModelAndView orderinquiry (HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		String phone = session.getAttribute("phone").toString();
		ModelAndView mv = new ModelAndView("people/findorder");
		List<Order> orders = ios.find(phone);
		mv.addObject("orders",orders);
		return mv;
	}
	//使用订单号查询订单信息
	@RequestMapping("/orderIdinquiry")
	public ModelAndView orderIdinquiry (HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		long id = Long.parseLong(request.getParameter("orderId"));
		ModelAndView mv = new ModelAndView("people/findorder");
		List<Order> orders = ios.find(id);
		mv.addObject("orders",orders);
		return mv;
	}
	//使用订单号查询订单信息并跳转退票页
	@RequestMapping("/tuipiao")
	public ModelAndView tuipiao (HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		long id = Long.parseLong(request.getParameter("orderId"));
		ModelAndView mv = new ModelAndView("sales/tuipiao");
		List<Order> orders = ios.find(id);
		mv.addObject("orders",orders);
		return mv;
	}
	//改签
	@RequestMapping("/gaiqian")
	public ModelAndView changing (HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		String phone = session.getAttribute("phone").toString();
		ModelAndView mv = new ModelAndView("sales/gaiqian");
		List<Order> orders = ios.find(phone);
		mv.addObject("orders",orders);
		return mv;
	}
	//创建订单
	@RequestMapping("/payment")
	public ModelAndView payment(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		String flightNumber=request.getParameter("flightNumber");
		String linkmanName=request.getParameter("linkmanname");
		String linkmanPhone=request.getParameter("linkmanphone");
		String prices=request.getParameter("Price");
		Double price = Double.parseDouble(prices);  //价格
		String status = "wfk";
		int operatorType = Integer.parseInt(session.getAttribute("identity").toString());
		String operatorPhone = session.getAttribute("phone").toString();//操作人手机号
		Order order = new Order(price, status, flightNumber, operatorType, operatorPhone, linkmanName, linkmanPhone);		
		long orderId = ios.save(order);
		String startDate = request.getParameter("startDate");
		String passengerName=request.getParameter("passengername");
		String certificationNumber=request.getParameter("certificationnumber");
		System.out.println(flightNumber);
		System.out.println(startDate);
		int flightId = ifs.listFlight(flightNumber, startDate).get(0).getFlightId();
		//跳转到支付页
		ModelAndView mv = new ModelAndView("people/payment");
		mv.addObject("orderId",orderId);
		mv.addObject("passengerName",passengerName);
		mv.addObject("certificationNumber",certificationNumber);
		mv.addObject("linkmanName",linkmanName);
		mv.addObject("linkmanPhone",linkmanPhone);
		List<FlightScheduler> acts = ifss.listFlightSchedulers(flightNumber);
		mv.addObject("flightId",flightId);
		mv.addObject("acts",acts);
		return mv;
	}
	//支付
	@RequestMapping("/paymentsuccess")
	public ModelAndView paymentsuccess(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		long orderId=Long.parseLong(request.getParameter("orderId").toString());
		String passengerName=request.getParameter("passengerName");
		String certificationNumber=request.getParameter("certificationNumber");
		String linkmanPhone=request.getParameter("linkmanPhone");
		int flightId=Integer.parseInt(request.getParameter("flightId").toString());
		String level = "j";
		String passengerType = "c";
		TicketOrder ticketOrder = new TicketOrder(flightId, passengerName, certificationNumber, level, passengerType,orderId);
		itos.saveOrUpdate(ticketOrder);
		//跳转到支付页
		ModelAndView mv = new ModelAndView("people/findorder");
		List<Order> orders = ios.find(orderId);
		mv.addObject("orders",orders);
		mv.addObject("linkmanPhone",linkmanPhone);
		System.out.println(orders);
		return mv;
	}
}