package controller;
/*
 * 用户Controller
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.People;
import service.prototype.IPeopleService;

@Controller
public class PeopleController {
	@Autowired 
	private IPeopleService ips;
	//
	@RequestMapping("/peopleseekflight")
	public String index() {
		return "people/seekflight";
	}
	//修改个人信息页面
	@RequestMapping("/setdata")
	public ModelAndView setDate(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		String phone = session.getAttribute("phone").toString();
		ModelAndView mv = new ModelAndView("people/setdata");
		List<People> acts = ips.find(phone);
		mv.addObject("acts",acts);
		return mv;
	}
	//修改密码页面
	@RequestMapping("/setpassword")
	public String setpassword() {
		return "people/setpassword";
	}
	//后台修改数据
	@RequestMapping("/setdataService")
	@ResponseBody
	public String setpasswordservlei(HttpServletRequest request,HttpServletResponse response) {
		String phone=request.getParameter("phone");
		String peopleName=request.getParameter("name");
		String idCard=request.getParameter("idCard");
		int id=Integer.parseInt(request.getParameter("id"));
		People peop = new People(id, peopleName,phone, idCard);
		return ips.saveOrUpdate(peop)+"";
	}
	//后台修改密码
	@RequestMapping("/setpasswordservice")
	@ResponseBody
	public String serpasswordservice(HttpServletRequest request,HttpServletResponse response) {
		String phone=request.getParameter("phone");
		String peopleName=request.getParameter("password");
		int id=Integer.parseInt(request.getParameter("id"));
		People peop = new People(id,phone,peopleName);
		return ips.saveOrUpdate(peop)+"";
	}
	
}
