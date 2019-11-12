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

import entity.Order;
import service.prototype.IOrderService;

@Controller
public class OrderController {
	
	@Autowired
	private IOrderService ios;	
	//使用手机号查询订单信息
	@RequestMapping("/orderinquiry")
	public ModelAndView setdataService (HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		String phone = session.getAttribute("phone").toString();
		ModelAndView mv = new ModelAndView("people/findorder");
		List<Order> orders = ios.find(phone);
		System.out.println(orders);
		mv.addObject("orders",orders);
		return mv;
	}
}
