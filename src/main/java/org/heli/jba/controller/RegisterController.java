package org.heli.jba.controller;

import javax.validation.Valid;

import org.heli.jba.entity.User;
import org.heli.jba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/register")
public class RegisterController {
	/**
	 * have to know why?
	 * 
	 * @return
	 */
	@ModelAttribute("user")
	public User construct() {
		return new User();
	}

	@Autowired
	private UserService userService;

	@RequestMapping
	public String showRegistrer() {
		return "user-register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doRegistrer(@Valid @ModelAttribute("user") User user,
			BindingResult result) {
		if (result.hasErrors()) {
			return "user-register";
		}
		userService.save(user);
		return "redirect:/register.html?success=true";
	}

	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username) {
		Boolean available = userService.findOne(username) == null;
		return available.toString();
	}
}
