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

import com.arkr.electronicstore.models.NavItems;
import com.arkr.electronicstore.models.NavitemsDto;
import com.arkr.electronicstore.services.NavitemsRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/navitems")
public class NavItemsController {

	@Autowired
	private NavitemsRepository repo;
		
	
	@GetMapping({"","/"})
	public String showNavigation(Model model) {
		List<NavItems> navitems = repo.findAll();
		model.addAttribute("navitems", navitems);
		return "navbar/navitemsindex";
	}
	
	
	@GetMapping("/create")
	public String showcreatenavbar(Model model) {
		NavitemsDto navitemsDto = new NavitemsDto();
		model.addAttribute("navitemsDto", navitemsDto);
		return "navbar/createnavitems";
	}

	@PostMapping("/create")
	public String createNavbar(@Valid @ModelAttribute NavitemsDto navitemsDto , BindingResult result) {
		
		if (result.hasErrors()) {
			return "navbar/createnavitems";
		}
		
		NavItems navitems = new NavItems();
		navitems.setAboutus(navitemsDto.getAboutus());
		navitems.setContactus(navitemsDto.getContactus());
		navitems.setDeals(navitemsDto.getDeals());
		navitems.setFeedback(navitemsDto.getFeedback());
		navitems.setHome(navitemsDto.getHome());
		navitems.setService(navitemsDto.getService());
		navitems.setLogin(navitemsDto.getLogin());
		navitems.setLogout(navitemsDto.getLogout());
		
		repo.save(navitems);
		
		return "redirect:/navitems";
	}

	@GetMapping("/edit")
	public String showEditNavbar(Model model, @RequestParam int id) {
		
		try {
			NavItems navitems = repo.findById(id).get();
			model.addAttribute("navitems", navitems);
			
			NavitemsDto navitemsDto = new NavitemsDto();
			
			navitemsDto.setAboutus(navitems.getAboutus());
			navitemsDto.setContactus(navitems.getContactus());
			navitemsDto.setDeals(navitems.getDeals());
			navitemsDto.setFeedback(navitems.getFeedback());
			navitemsDto.setHome(navitems.getHome());
			navitemsDto.setService(navitems.getService());
			navitemsDto.setLogin(navitems.getLogin());
			navitemsDto.setLogout(navitems.getLogout());
			}
		catch (Exception e) {
			System.out.println(e);
			return "redirect:/navitems";
		}
		return "navbar/editnavitems";
	}
	
	@PostMapping("/edit")
	public String updatenavbar(Model model, @RequestParam int id, @Valid @ModelAttribute NavitemsDto navitemsDto, BindingResult result) {
					
		NavItems navitems = repo.findById(id).get();
			model.addAttribute("navitems", navitems);
			
			navitems.setAboutus(navitemsDto.getAboutus());
			navitems.setContactus(navitemsDto.getContactus());
			navitems.setDeals(navitemsDto.getDeals());
			navitems.setFeedback(navitemsDto.getFeedback());
			navitems.setHome(navitems.getHome());
			navitems.setService(navitemsDto.getService());
			navitems.setLogin(navitemsDto.getLogin());
			navitems.setLogout(navitemsDto.getLogout());
			
			repo.save(navitems);
			
			return "redirect:/navitems";
		}
	
	@GetMapping("/delete")
	public String DeleteNavbar(@RequestParam int id ) {
		
		try {	
			NavItems navitems= repo.findById(id).get();
			repo.delete(navitems);
		}catch(Exception e) {
			System.out.println(e);
		}
		return "redirect:/navitems/";
	}
	
	

}
