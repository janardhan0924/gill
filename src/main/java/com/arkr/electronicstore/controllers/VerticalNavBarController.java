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

import com.arkr.electronicstore.models.VerticalNavbar;
import com.arkr.electronicstore.models.VerticalNavbarDto;
import com.arkr.electronicstore.services.VerticalNavBarRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/verticalnavbar")
public class VerticalNavBarController {


	@Autowired
	private VerticalNavBarRepository repo;


	@GetMapping({"","/"})
	public String showPopup(Model model) {
		List<VerticalNavbar> verticalnavbar = repo.findAll();
		model.addAttribute("verticalnavbar", verticalnavbar);
		return "navbar/verticalnavbarindex";
	}
		
	@GetMapping("/create")
	public String showcreatenavbar(Model model) {
		VerticalNavbarDto verticalnavbarDto = new VerticalNavbarDto();
		model.addAttribute("verticalnavbarDto", verticalnavbarDto);
		return "navbar/createverticalnavbar";
	}

	@PostMapping("/create")
	public String createNavbar(@Valid @ModelAttribute VerticalNavbar verticalnavbarDto , BindingResult result) {
		
		if (result.hasErrors()) {
			return "navbar/createverticalnavbar";
		}
		
		VerticalNavbar verticalnavbar = new VerticalNavbar();
		verticalnavbar.setHeading1(verticalnavbarDto.getHeading1());
		verticalnavbar.setHeading2(verticalnavbarDto.getHeading2());
		verticalnavbar.setHeading3(verticalnavbarDto.getHeading3());
		verticalnavbar.setHeading4(verticalnavbarDto.getHeading4());
		verticalnavbar.setHeading5(verticalnavbarDto.getHeading5());
		verticalnavbar.setHeading6(verticalnavbarDto.getHeading6());
		
		repo.save(verticalnavbar);
		
		return "redirect:/verticalnavbar";
	}

	@GetMapping("/edit")
	public String showEditNavbar(Model model, @RequestParam int id) {
		
		try {
			VerticalNavbar verticalnavbar = repo.findById(id).get();
			model.addAttribute("verticalnavbar", verticalnavbar);
			
			VerticalNavbarDto vertialnavbarDto = new VerticalNavbarDto();
			vertialnavbarDto.setHeading1(verticalnavbar.getHeading1());
			vertialnavbarDto.setHeading2(verticalnavbar.getHeading2());
			vertialnavbarDto.setHeading3(verticalnavbar.getHeading3());
			vertialnavbarDto.setHeading4(verticalnavbar.getHeading4());
			vertialnavbarDto.setHeading5(verticalnavbar.getHeading5());
			vertialnavbarDto.setHeading6(verticalnavbar.getHeading6());

			}
		catch (Exception e) {
			System.out.println(e);
			return "redirect:/verticalnavbar";
		}
		return "navbar/editvarticalnavbar";
	}
	
	@PostMapping("/edit")
	public String updatenavbar(Model model, @RequestParam int id, @Valid @ModelAttribute VerticalNavbarDto verticalnavbarDto, BindingResult result) {
					
		VerticalNavbar verticalnavbar = repo.findById(id).get();
			model.addAttribute("verticalnavbar", verticalnavbar);
			verticalnavbar.setHeading1(verticalnavbarDto.getHeading1());
			verticalnavbar.setHeading2(verticalnavbarDto.getHeading2());
			verticalnavbar.setHeading3(verticalnavbarDto.getHeading3());
			verticalnavbar.setHeading4(verticalnavbarDto.getHeading4());
			verticalnavbar.setHeading5(verticalnavbarDto.getHeading5());
			verticalnavbar.setHeading6(verticalnavbarDto.getHeading6());
			
			repo.save(verticalnavbar);
			
			return "redirect:/verticalnavbar";
		}
	
	@GetMapping("/delete")
	public String DeleteNavbar(@RequestParam int id ) {
		
		try {	
			VerticalNavbar verticalnavbar=repo.findById(id).get();	
			repo.delete(verticalnavbar);
		}catch(Exception e) {
			System.out.println(e);
		}
		return "redirect:/verticalnavbar/";
	}
	
}