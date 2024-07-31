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
import org.springframework.web.multipart.MultipartFile;

import com.arkr.electronicstore.models.Carousel;
import com.arkr.electronicstore.models.CarouselDto;
import com.arkr.electronicstore.services.CarouselRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/carousel")
public class CarouselController {

	@Autowired
	private CarouselRepository repo;
	
	@GetMapping({" ", "/"})
	public String  showCarouselList(Model model) {
		List<Carousel> carousel =repo.findAll();
		model.addAttribute("carousel", carousel);
		return "carousel/index";
	}

}

	