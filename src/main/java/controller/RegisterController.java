package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.People;
import service.prototype.IPeopleService;

/*
 * 注册Controller
 */
@Controller
public class RegisterController {

	@Autowired
	private IPeopleService ips;
	//注册页
	@RequestMapping("/register")
	public String index() {
		return "people/register";
	}
	//注册后台处理
	@RequestMapping("/registerservice")
	public void registerservice(HttpServletRequest request,HttpServletResponse response) {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String idCard = request.getParameter("idCard");
		String password = request.getParameter("password");
		People peop = new People(name,password,phone,idCard);
		int i=0;
		i = ips.saveOrUpdate(peop);
		if(i>0) {
			try {
				response.sendRedirect("/hangkong/login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				response.sendRedirect("register");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//--注册验证手机号是否被注册
	@PostMapping("/phoneverify")
	@ResponseBody
	public String phonecerify(String phone) {
		People people = null;
		try {
			people = ips.find(phone);
			if(people.getPeopleId()>0) {
				return "false";
			}else {
				return "true";
			}
		}catch (Exception e) {
			return "true";
		}
		
	}
}
