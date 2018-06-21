package at.fh.swenga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.model.User;
import at.fh.swenga.repositories.UserRepository;

@Controller
public class AdminController 
{
	@Autowired
	UserRepository userRepo;

	@RequestMapping(value = { "/adminSettings" })
	public String adminSettings(Model model) 
	{ 
		
		model.addAttribute("users", userRepo.findAll());
		return "adminSettings"; 
	}
	
	@Transactional
	@RequestMapping(value="/deleteSelectedUser", method = RequestMethod.GET)
	public String delete(Model model, @RequestParam(value="name") String name) 
	{ 
		if(name.equals("admin"))
			model.addAttribute("error", "Admin can't be deleted");
		else
		{
			userRepo.deleteByName(name);
			model.addAttribute("deleted", "User deleted");
		}
		return "forward:/adminSettings";
	}
	
	@Transactional
	@RequestMapping(value="/activateUser", method = RequestMethod.POST)
	public String activate(Model model, @RequestParam(value="name") String name) 
	{ 
		User user = userRepo.findByName(name);
		user.setAktiv(true);
		return "forward:/adminSettings";
	}
	
	@Transactional
	@RequestMapping(value="/lockUser", method = RequestMethod.POST)
	public String lock(Model model, @RequestParam(value="name") String name) 
	{ 
		User user = userRepo.findByName(name);
		user.setAktiv(false);
		return "forward:/adminSettings";
	}
	
	/*@Transactional
	@RequestMapping(value="/editUser", method = RequestMethod.POST)
	public String editUser(Model model, @RequestParam(required=false, value="name") String name, @RequestParam(value="activate", required=false) String activate,
			@RequestParam(value="delete", required=false) String delete) 
	{ 
		if(delete != null)
		{
			userRepo.deleteByName(name);
			return "forward:/adminSettings";
		}
		else if(activate != null)
		{
			User user = userRepo.findByName(name);
			if(user.isAktiv() == true)
				user.setAktiv(false);
			else
				user.setAktiv(true);
			

			return "forward:/adminSettings";
		}
		
		return "forward:/adminSettings";
	}*/
}