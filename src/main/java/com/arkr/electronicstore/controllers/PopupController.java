package com.arkr.electronicstore.controllers;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.arkr.electronicstore.models.Popup;
import com.arkr.electronicstore.models.PopupDto;
import com.arkr.electronicstore.services.PopupRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/popup")
public class PopupController {

	@Autowired
	private PopupRepository repo;


	@GetMapping({"","/"})
	public String showPopup(Model model) {
		List<Popup> popup = repo.findAll();
		model.addAttribute("popup", popup);
		return "popup/index";
	}
	
	@GetMapping("/create")
	public String showCreatePage(Model model) {
		PopupDto popupDto = new PopupDto();
		model.addAttribute("popupDto",popupDto);
		return "popup/createpopup";
	}
		
@PostMapping("/create")
	public String createProuct(
		@Valid @ModelAttribute PopupDto popupDto, BindingResult result) {
			
		if(popupDto.getImageFileName().isEmpty()) {
		result.addError(new FieldError("popupDto","imageFileName","the image file is required"));
		}
		if(result.hasErrors()) {
			return "popup/createpopup";
		}
		
//saving the Image File
			
MultipartFile image = popupDto.getImageFileName();
		String storageFileName = "_"+image.getOriginalFilename();
		
		try {
			String uploadDir = "public/images/";
			Path uploadPath = Paths.get(uploadDir);
			
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			
		try(InputStream inputStream = image.getInputStream()) {
				Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
						StandardCopyOption.REPLACE_EXISTING);
			}
		
		}catch(Exception ex) {
			System.out.println("Exception : " + ex.getMessage());
		}
		
		Popup popup = new Popup();
		popup.setName(popupDto.getName());
		popup.setDescription(popupDto.getDescription());
		popup.setImageFileName(storageFileName);
			
		repo.save(popup);
			
		return "redirect:/popup";
	}
	

@GetMapping("/edit")
public String showEditPage(Model model, @RequestParam int id) {
		
try {
	Popup popup = repo.findById(id).get();
	model.addAttribute("popup",popup);
			
	PopupDto popupDto = new PopupDto();
	popupDto.setName(popup.getName());
	popupDto.setDescription(popup.getDescription());
			
	model.addAttribute("popupDto",popupDto);
	}
		
catch(Exception ex) {
System.out.println("Exception: " + ex.getMessage());
return "redirect:/popup";
}
return "popup/editpopup";
}
			
@PostMapping("/edit")
public String updateProduct(Model model, @RequestParam int id,@Valid @ModelAttribute PopupDto popupDto,BindingResult result) {
				
try {
	Popup popup=repo.findById(id).get();
	model.addAttribute("popup", popup);
					
if(result.hasErrors()) {
	return "popup/editpopup";
}
					
if(!popupDto.getImageFileName().isEmpty()) {
//for deleting the old image
	String uploadDir="public/images/";
	Path oldImagePath = Paths.get(uploadDir + popup.getImageFileName());
						
	try {
		Files.delete(oldImagePath);
	}
						
	catch(Exception ex) {
		System.out.println("Exception: " + ex.getMessage());
	}
//save the new image
						
	MultipartFile  image = popupDto.getImageFileName();
		String storageFileName = "_"+image.getOriginalFilename();
						
	try(InputStream inputStream = image.getInputStream()){
		Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
		StandardCopyOption.REPLACE_EXISTING);
	}
		popup.setImageFileName(storageFileName);
	}
	popup.setName(popupDto.getName());
	popup.setDescription(popupDto.getDescription());
						
	repo.save(popup);
	}
				
catch(Exception ex) {
	System.out.println("Exception: " + ex.getMessage());
}
	return "redirect:/popup";
}
			
@GetMapping("/delete")
public String deleteProduct(@RequestParam int id) {
				
try {
	Popup popup = repo.findById(id).get();
	
	//For Deleting Image File
					
	Path imagePath = Paths.get("public/images/" + popup.getImageFileName());
					
try {
	Files.delete(imagePath);
}
					
catch(Exception ex) {
	System.out.println("Exception: " + ex.getMessage());
}
					
//To delete the product
repo.delete(popup);
}
				
				
catch(Exception ex) {
	System.out.println("Exception: " + ex.getMessage());
}
	return "redirect:/popup";
}
		
}
