package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.People;
import entity.Sales;
import service.prototype.IPeopleService;
import service.prototype.ISalesService;

/*
 * 营业员Controller
 */
@Controller
public class SalesController {
	@Autowired
	private ISalesService iss;
	@Autowired
	private IPeopleService ips;
	//用户查询页
	@RequestMapping("inquirepeople")
	public String inquirepeopleAger() {
		return "/sales/inquirepeopleager";
	}
	//用户查询按手机号
	@RequestMapping("inquirephone")
	@ResponseBody
	public String salesphone(HttpServletRequest request,HttpServletResponse response) {
		String phone = request.getParameter("phone");
		return JSON.toJSONString(ips.find(phone).toString());
	}
	//用户查询按用户名
	@RequestMapping("inquirename")
	@ResponseBody
	public String salesname(HttpServletRequest request,HttpServletResponse response) {
		String name = request.getParameter("name");
		return ips.nameFind(name).toString();
	}
	//航班查询
	@RequestMapping("seekflight")
	public String seekflight() {
		return "/sales/seekflight";
	}
	//退票
	@RequestMapping("refund")
	public String refund() {
		return "/sales/refund";
	}
	//改签
	@RequestMapping("changing")
	public String changing() {
		return "/sales/changing";
	}
	//删除一条营业员信息
	@GetMapping("/deletesales/{salesId}")
	public ModelAndView deletesales(@PathVariable("salesId") int salesId) {
		iss.delete(salesId);
		ModelAndView modelAndView = new ModelAndView("admin/sales");
		List<Sales> findAll = iss.findAll();
		modelAndView.addObject("findAll",findAll);
		return modelAndView;
	}
	@RequestMapping("queryOrder")
	public String queryOrder() {		
		return "sales/queryorder";	
	}
	@RequestMapping(value = "salesfindpeople", produces = {"application/text;charset=UTF-8"})
	@ResponseBody
	public String findpeople(String phone) {
		People people = ips.find(phone);
		return JSON.toJSONString(people);	
	}
	
}
