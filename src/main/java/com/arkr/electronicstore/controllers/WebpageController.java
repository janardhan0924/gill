package com.arkr.electronicstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arkr.electronicstore.models.NavItems;
import com.arkr.electronicstore.models.Navbar;
import com.arkr.electronicstore.models.Popup;
import com.arkr.electronicstore.models.Product;
import com.arkr.electronicstore.models.VerticalNavbar;
import com.arkr.electronicstore.services.NavbarRepository;
import com.arkr.electronicstore.services.NavitemsRepository;
import com.arkr.electronicstore.services.PopupRepository;
import com.arkr.electronicstore.services.ProductRepository;
import com.arkr.electronicstore.services.VerticalNavBarRepository;


@Controller
@RequestMapping("/webpage")
public class WebpageController {

	@Autowired
	private ProductRepository productrepo;
	@Autowired
	private NavbarRepository navbarrepo;
	@Autowired
	private NavitemsRepository navitemrepo;
	@Autowired
	private VerticalNavBarRepository verticalnavbarrepo;
	@Autowired
	private PopupRepository popuprepo;
	
	@GetMapping({"","/"})
	public String webpage(Model model) {
		List<Product> product =productrepo.findAll();
		model.addAttribute("product", product);
		
		List<Navbar> navbar =navbarrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		List<NavItems> navitems =navitemrepo.findAll();
		model.addAttribute("navitems", navitems);
		
		List<VerticalNavbar> verticalnavbar = verticalnavbarrepo.findAll();
		model.addAttribute("verticalnavbar", verticalnavbar);
		
		List<Popup>popup =popuprepo.findAll();
		model.addAttribute("popup",popup);
		
		return "webpage/webpage";	
	}
	
	@GetMapping("/home")
	public String webpagehome(Model model) {
		List<Product> product =productrepo.findAll();
		model.addAttribute("product", product);
		
		List<Navbar> navbar =navbarrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		List<NavItems> navitems =navitemrepo.findAll();
		model.addAttribute("navitems", navitems);
		
		List<VerticalNavbar> verticalnavbar = verticalnavbarrepo.findAll();
		model.addAttribute("verticalnavbar", verticalnavbar);
		
		List<Popup>popup =popuprepo.findAll();
		model.addAttribute("popup",popup);
		
		return "webpage/home";	
	}
	
	@GetMapping("/about")
	public String webpageabout(Model model) {
		List<Product> product =productrepo.findAll();
		model.addAttribute("product", product);
		
		List<Navbar> navbar =navbarrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		List<NavItems> navitems =navitemrepo.findAll();
		model.addAttribute("navitems", navitems);
		
		List<VerticalNavbar> verticalnavbar = verticalnavbarrepo.findAll();
		model.addAttribute("verticalnavbar", verticalnavbar);
		
		List<Popup>popup =popuprepo.findAll();
		model.addAttribute("popup",popup);
		
		return "webpage/about";	
	}
	
	
	@GetMapping("/deals")
	public String webpagedeals(Model model) {
		List<Product> product =productrepo.findAll();
		model.addAttribute("product", product);
		
		List<Navbar> navbar =navbarrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		List<NavItems> navitems =navitemrepo.findAll();
		model.addAttribute("navitems", navitems);
		
		List<VerticalNavbar> verticalnavbar = verticalnavbarrepo.findAll();
		model.addAttribute("verticalnavbar", verticalnavbar);
		
		List<Popup>popup =popuprepo.findAll();
		model.addAttribute("popup",popup);
		
		return "webpage/deals";	
	}
	
	@GetMapping("/feedback")
	public String webpagefeedback(Model model) {
		List<Product> product =productrepo.findAll();
		model.addAttribute("product", product);
		
		List<Navbar> navbar =navbarrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		List<NavItems> navitems =navitemrepo.findAll();
		model.addAttribute("navitems", navitems);
		
		List<VerticalNavbar> verticalnavbar = verticalnavbarrepo.findAll();
		model.addAttribute("verticalnavbar", verticalnavbar);
		
		List<Popup>popup =popuprepo.findAll();
		model.addAttribute("popup",popup);
		
		return "webpage/feedback";	
	}
	
	
	@GetMapping("/login")
	public String webpagelogin(Model model) {
		List<Product> product =productrepo.findAll();
		model.addAttribute("product", product);
		
		List<Navbar> navbar =navbarrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		List<NavItems> navitems =navitemrepo.findAll();
		model.addAttribute("navitems", navitems);
		
		List<VerticalNavbar> verticalnavbar = verticalnavbarrepo.findAll();
		model.addAttribute("verticalnavbar", verticalnavbar);
		
		List<Popup>popup =popuprepo.findAll();
		model.addAttribute("popup",popup);
		
		return "webpage/login";	
	}
	
}
