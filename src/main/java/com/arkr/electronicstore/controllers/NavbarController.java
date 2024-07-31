package com.arkr.electronicstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arkr.electronicstore.models.Navbar;
import com.arkr.electronicstore.models.NavbarDto;
import com.arkr.electronicstore.services.NavbarRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/navbar")
public class NavbarController {
	
	@Autowired
	private NavbarRepository repo;
	
	@GetMapping({"","/"})
	public String showNavbarList(Model model) {
		List<Navbar> navbar =repo.findAll();
		model.addAttribute("navbar",navbar);
		return "navbar/navbarindex";
	}
	
	@GetMapping("/create")
	public String showcreatenavbar(Model model) {
		NavbarDto navbarDto = new NavbarDto();
		model.addAttribute("navbarDto", navbarDto);
		return "navbar/createnavbar";
	}

	@PostMapping("/create")
	public String createNavbar(@Valid @ModelAttribute NavbarDto navbarDto , BindingResult result) {
		
		if (result.hasErrors()) {
			return "navbar/createnavbar";
		}
		
		Navbar navbar = new Navbar();
		navbar.setAboutus(navbarDto.getAboutus());
		navbar.setContactus(navbarDto.getContactus());
		navbar.setDeals(navbarDto.getDeals());
		navbar.setFeedback(navbarDto.getFeedback());
		navbar.setHome(navbarDto.getHome());
		navbar.setService(navbarDto.getService());
		navbar.setLogin(navbarDto.getLogin());
		navbar.setLogout(navbarDto.getLogout());
		
		repo.save(navbar);
		
		return "redirect:/navbar";
	}

	@GetMapping("/edit")
	public String showEditNavbar(Model model, @RequestParam int id) {
		
		try {
			Navbar navbar = repo.findById(id).get();
			model.addAttribute("navbar", navbar);
			
			NavbarDto navbarDto = new NavbarDto();
			
			navbarDto.setAboutus(navbar.getAboutus());
			navbarDto.setContactus(navbar.getContactus());
			navbarDto.setDeals(navbar.getDeals());
			navbarDto.setFeedback(navbar.getFeedback());
			navbarDto.setHome(navbar.getHome());
			navbarDto.setService(navbar.getService());
			navbarDto.setLogin(navbar.getLogin());
			navbarDto.setLogout(navbar.getLogout());
			}
		catch (Exception e) {
			System.out.println(e);
			return "redirect:/navbar";
		}
		return "navbar/editnavbar";
	}
	
	@PostMapping("/edit")
	public String updatenavbar(Model model, @RequestParam int id, @Valid @ModelAttribute NavbarDto navbarDto, BindingResult result) {
					
			Navbar navbar = repo.findById(id).get();
			model.addAttribute("navbar", navbar);
			
			navbar.setAboutus(navbarDto.getAboutus());
			navbar.setContactus(navbarDto.getContactus());
			navbar.setDeals(navbarDto.getDeals());
			navbar.setFeedback(navbarDto.getFeedback());
			navbar.setHome(navbarDto.getHome());
			navbar.setService(navbarDto.getService());
			navbar.setLogin(navbarDto.getLogin());
			navbar.setLogout(navbarDto.getLogout());
			
			repo.save(navbar);
			
			return "redirect:/navbar";
		}
	
	@GetMapping("/delete")
	public String DeleteNavbar(@RequestParam int id ) {
		
		try {	
			Navbar navbar=repo.findById(id).get();	
			repo.delete(navbar);
		}catch(Exception e) {
			System.out.println(e);
		}
		return "redirect:/navbar/";
	}
	
}
