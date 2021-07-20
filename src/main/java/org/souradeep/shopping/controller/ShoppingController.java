package org.souradeep.shopping.controller;

import org.souradeep.shopping.repository.ProductRepository;
import org.souradeep.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {

	@Autowired
	ProductRepository productRepo;
	@Autowired
	UserRepository userRepo;

	@GetMapping(value = "/", produces = "text/plain")
	public String home() {
		//		productRepo.findAll().forEach(System.out::println);
		userRepo.findAll().forEach(System.out::println);
		return "";
	}

	@PostMapping(value = "/", produces = "text/plain")
	public String home1() {
		return "post";
	}

}
