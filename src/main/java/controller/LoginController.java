package controller;
/*
 * 登录COntroller
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.People;
import entity.Sales;
import service.prototype.IAdminService;
import service.prototype.IPeopleService;
import service.prototype.ISalesService;

@Controller
public class LoginController {

	@Autowired
	private IPeopleService ips;
	@Autowired
	private IAdminService ias;
	@Autowired
	private ISalesService iss;
	//index进入登录页
	@RequestMapping("/index")
	public String index() {
		return "people/index";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	//进入数据管理员页面
	@RequestMapping("/admin")
	public String admin() {
		return "admin/admin";
	}
	//进入管理员界面
	@RequestMapping("/sales")
	public String sales() {
		return "sales/sales";
	}
	//进入用户页面
	@RequestMapping("/people")
	public String people() {
		return "people/people";
	}
	//登录验证
	@RequestMapping("/loginservice")
	public void loginservice(HttpServletRequest request,HttpServletResponse response) {
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		int identity=Integer.parseInt(request.getParameter("identity"));
		if(identity==1) {
			int result = ias.login(phone,password);
			if(result>0) {
				request.getSession().setAttribute("phone", phone);
				request.getSession().setAttribute("login", "yes");
				request.getSession().setAttribute("identity", identity);
				try {
					response.sendRedirect("admin");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				try {
					response.sendRedirect("login");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else if(identity==2){
			int result = iss.login(phone, password);
			if(result>0) {
				request.getSession().setAttribute("phone", phone);
				request.getSession().setAttribute("login", "yes");
				request.getSession().setAttribute("identity", identity);
				try {
					response.sendRedirect("sales");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				try {
					response.sendRedirect("login");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			List<People> result = ips.login(phone, password);
			if(result.size()>0) {
				request.getSession().setAttribute("phone", phone);
				request.getSession().setAttribute("login", "yes");
				request.getSession().setAttribute("identity", identity);
				try {
					response.sendRedirect("index");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				try {
					response.sendRedirect("login");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//获取用户名
	@GetMapping(value = "/uname" , produces = {"application/text;charset=UTF-8"})
	@ResponseBody
	public String username(HttpSession session) {
		if("yes".equals(session.getAttribute("login")+"")){
			String phone = session.getAttribute("phone").toString();
			int identity = Integer.parseInt(session.getAttribute("identity").toString());
			if(identity==1) {
				People resu = ips.find(phone);
				return resu.getPeopleName();
			}else if(identity==2) {
				Sales resu = iss.find(phone);
				return resu.getSalesName();
			}else {
				People resu = ips.find(phone);
				return resu.getPeopleName();
			}
		}
		return "";
	}
	//退出登录
	@RequestMapping("/outlogin")
	public void outlogin(HttpSession session,HttpServletResponse response) {
		if("yes".equals(session.getAttribute("login"))){
			session.removeAttribute("login");
			session.removeAttribute("phone");
		}
		try {
			response.sendRedirect("index");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
