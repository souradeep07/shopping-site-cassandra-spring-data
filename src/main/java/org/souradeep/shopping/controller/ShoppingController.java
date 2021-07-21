package org.souradeep.shopping.controller;

import java.util.UUID;

import org.souradeep.shopping.data.entity.Product;
import org.souradeep.shopping.data.entity.User;
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

	@GetMapping(value = "/", produces = "application/json")
	public Product home() {
		//		productRepo.findAll().forEach(System.out::println);
		userRepo.findAll().forEach(System.out::println);
		return productRepo.findById(UUID.fromString("eccdb623-aac5-44d4-b4dd-cb1edac71fea")).get();
	}

	@PostMapping(value = "/", produces = "application/json")
	public User home1() {
		return userRepo.findById(UUID.fromString("1354650a-0654-4326-b586-9e39872e48aa")).get();
	}

}
