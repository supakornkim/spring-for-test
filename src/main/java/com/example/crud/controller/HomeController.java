package com.example.crud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.crud.model.Student;
import com.example.crud.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService stdService;

	@GetMapping("/")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/forgotpassword")
	public String forgotpassword() {
		return "forgotpassword";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@GetMapping("/category")
	public String category() {
		return "category";
	}

	@GetMapping("/student")
	public ModelAndView student() {
		List<Student> list = stdService.findAll();
		// System.out.println(list);
		return new ModelAndView("student", "list", list);
	}

	@GetMapping("/newstudent")
	public String newRegistration(ModelMap map) {
		Student student = new Student();
		map.addAttribute("student", student);
		return "newstudent";
	}

	@PostMapping("/savestudent")
	public String saveStudent(@Valid Student student, BindingResult result, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "newstudent";
		} else {
			stdService.save(student);
			return "redirect:/student";
		}

	}

	@GetMapping(value = "/editstudent/{id}")
	public String edit(@PathVariable int id, ModelMap model) {
		Student student = stdService.getOne(id);
		model.addAttribute("student", student);
		return "editstudent";
	}

	// Edit submit Student
	@PostMapping(value = "/editsave")
	public String editsave(@Valid @ModelAttribute("student") Student p, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "editstudent";
		} else {

			Student std = stdService.getOne(p.getId());

			std.setFirstName(p.getFirstName());
			std.setLastName(p.getLastName());
			std.setCountry(p.getCountry());
			std.setEmail(p.getEmail());
			std.setSection(p.getSection());
			std.setSex(p.getSex());

			stdService.save(std);
			return "redirect:/student";
		}
	}

	/* Delete Student */
	@GetMapping(value = "/deletestudent/{id}")
	public ModelAndView delete(@PathVariable int id) {
		Student student = stdService.getOne(id);
		stdService.delete(student);
		return new ModelAndView("redirect:/student");
	}

	@ModelAttribute("countries")
	public List<String> initializeCountries() {
		List<String> countries = new ArrayList<String>();
		countries.add("Thailand");
		countries.add("Laos");
		countries.add("Cambodia");
		countries.add("USA");
		countries.add("Japan");
		return countries;
	}

	@ModelAttribute("sections")
	public List<String> initializeSections() {
		List<String> sections = new ArrayList<String>();
		sections.add("Marketing");
		sections.add("IT");
		sections.add("Purchasing");
		sections.add("Sales");
		sections.add("Support");
		return sections;
	}

}