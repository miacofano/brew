package com.java.brew.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.java.brew.models.Bean;
import com.java.brew.models.LoginUser;
import com.java.brew.models.User;
import com.java.brew.services.BeanService;
import com.java.brew.services.UserService;




@Controller
public class MainController {
	
	//SERVICES
	@Autowired
	private UserService users;
	@Autowired 
	private BeanService beans;
		
	//GET METHODS
	//LOGIN & REGISTRATION
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	//LOGOUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//HOME PAGE
	@GetMapping("/beans")
	public String home(Model model, HttpSession session ) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		model.addAttribute("beans", beans.all());
		model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
		return "home.jsp";
	}	
	
	//VIEW BEAN
	@GetMapping("/beans/{id}")
	public String viewBean(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Bean bean = beans.findById(id);
		model.addAttribute("bean", bean);
		model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
		return "viewBean.jsp";
	}
	
	//BEAN FORM
	@GetMapping("/beans/new")
	public String newBean(@ModelAttribute("bean") Bean bean, Model model, HttpSession session) {
		User user = users.findById((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "newBean.jsp";
	}
	
	//DELETE BEAN
	@GetMapping("/beans/{id}/delete")
	public String deleteBean(@PathVariable("id") Long id, HttpSession session) {
	    if(session.getAttribute("userId") == null) {
	    	return "redirect:/";
	    }
	    Bean bean = beans.findById(id);
	    beans.delete(bean);
	    return "redirect:/beans";
	}
	
	//EDIT BEAN FORM
	@GetMapping("/beans/{id}/edit")
    public String editBean(Model model, @PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Bean bean = beans.findById(id);
    	model.addAttribute("bean", bean);
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	return "editBean.jsp";
    }
	
	//POST METHODS
	//REGISTER USER
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User user = users.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/beans";
	}
	
	//LOGIN USER
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = users.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/beans";
	}
	
	//CREATE NEW BEAN
	@PostMapping("/beans/new")
	public String createBean(@Valid @ModelAttribute("bean") Bean bean, BindingResult result) {
		if (result.hasErrors()) {
			return "newBean.jsp";
		}
		beans.create(bean);
		return "redirect:/beans";
	}
	
	//PUT METHODS
	//UPDATE BEAN
	@PutMapping("/beans/{id}/edit")
    public String updateBean(Model model, @Valid @ModelAttribute("bean") Bean bean, BindingResult result, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	if(result.hasErrors()) {
    		return "editBean.jsp";
    	}
    	beans.update(bean);
    	return "redirect:/beans";
    }
}
