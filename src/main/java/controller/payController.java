package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class payController {
	
	@PostMapping("atppj")
	public String pay() {
		return "/alpay/alipay.trade.page.pay";
	}
}
