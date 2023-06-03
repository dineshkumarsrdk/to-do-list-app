package com.dine.todolistapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userID")
public class HomeController {
	
	@GetMapping("/home")
	public String gotoHomePage(ModelMap model) {
		model.put("userID", getLoggedInUserID());
		return "homePage";
	}
	
	public String getLoggedInUserID() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		return authentication.getName();
	}
}
