package com.app.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.card.model.SaveUser;
import com.app.card.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping("/newuser")
	public String newUserPage(Model model) {
		SaveUser saveusers =  new SaveUser();
		model.addAttribute("saveusers", saveusers); 
		return "new_user";
	}
	
	@RequestMapping(value = "/saveuser", method =RequestMethod.POST)
	public String saveUser(@ModelAttribute("saveusers") SaveUser saveuser ) {
		service.save(saveuser);
		return "redirect:/";
	}
	
	
}
