package com.akhil.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akhil.entity.Student;
import com.akhil.repo.StudentRepo;

@Controller
public class HomeController {
//	@GetMapping("/")
//	public String hello(@RequestParam(value="name",defaultValue = "Akhil",required = true) String name,
//			Model model) {
//		model.addAttribute("name",name);
//		return "hello";
//	}
	@Autowired
	private StudentRepo repo;
	
	
	@GetMapping("/")
	public String hello() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
//	@PostMapping("/saveStudent")
//	public String saveStudent(@RequestParam("id") Integer id, @RequestParam("name") String name
//			,Model model) {
//		Student s = new Student(id,name);
//		repo.save(s);
//		model.addAttribute("name", name);
//		return "success";
//	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(Student s, Model model) {
		repo.save(s);
		model.addAttribute("name",s.getName());
		return "success";
	}
	
	@GetMapping("/getOneStudent/{id}")
	public String getOneStudent(@PathVariable Integer id,Model model) {
		Optional<Student> opt = repo.findById(id);
		Student s = null;
		if(opt.isPresent()) {
			s = opt.get();
		}
		model.addAttribute("name", s.getName());
		model.addAttribute("id", s.getId());
		model.addAttribute("stu", s);
		return "student";
	}
	
	@GetMapping("/getAllStudents")
	public String getAllStudents(Model model) {
		List<Student> list = repo.findAll();
		if(!list.isEmpty()) {
			
		}
		model.addAttribute("list", list);
		return "allstudents";
	}
	
	@GetMapping("/deleteOneStudent/{id}")
	public String deleteOneStudent(@PathVariable Integer id,Model model) {
		Optional<Student> opt = repo.findById(id);
		System.out.println("found styudent");
		Student s = null;
		if(opt.isPresent()) {
			s = opt.get();
			model.addAttribute("name", s.getName());
			model.addAttribute("id", s.getId());
			model.addAttribute("stu", s);
			repo.deleteById(id);
		}
		return "studentdelete";
	}
}
