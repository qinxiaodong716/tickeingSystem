package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.People;
import service.prototype.IPeopleService;

@Controller
public class LoginController {
	@Autowired
	private IPeopleService ips;
	
	@RequestMapping("/index")
	public String index() {
		return "login";
	}
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	@RequestMapping("/sales")
	public String sales() {
		return "sales";
	}
	@RequestMapping("/people")
	public String people() {
		return "people";
	}
	@RequestMapping("/loginservice")
	public void loginservice(HttpServletRequest request,HttpServletResponse response) {
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		int identity=Integer.parseInt(request.getParameter("identity"));
		List<People> result = ips.login(phone, password);
		String name=result.get(0).getPeopleName();
		if(result.size()>0) {
			try {
				if(identity==1) {
					response.sendRedirect("admin");
				}else if(identity==2){
					response.sendRedirect("sales");
				}else {
					request.getSession().setAttribute("name", name);
					request.getSession().setAttribute("phone", phone);
					response.sendRedirect("people");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				response.sendRedirect("index");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
