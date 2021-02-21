package com.app.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.card.model.Card;
import com.app.card.services.CardServices;

@Controller
public class CardController {

	@Autowired
	CardServices service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Card> listCards = service.listAll();
		Card card=new Card();
		model.addAttribute("currentUser",SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("listCards",listCards);
		model.addAttribute("card",card);
		return "index";
	}
	
	@RequestMapping(value = "/search", method =RequestMethod.GET)
	public String getSeach(Model model, @ModelAttribute("card") Card card ) {
		List<Card> listCards = service.listByCard(card);
		model.addAttribute("currentUser",SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("listCards",listCards);
		return "index";
	}
	
	@RequestMapping("/new")
	public String newCardPage(Model model) {
		Card card=new Card();
		model.addAttribute(card);
		return "new_card";
	}
	
	@RequestMapping(value = "/save", method =RequestMethod.POST)
	public String saveCard(@ModelAttribute("card") Card card ) {
		service.save(card);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCardPage(@PathVariable (name="id") Long id) {
		ModelAndView mav=new ModelAndView("edit_card");
		Card card=service.get(id);
		mav.addObject("card",card);
		return mav;
	}
	
	
}
