package com.example.SpringSecurityDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping("/public/all")
	public String forAll() {
		return "API for all";
	}
	@GetMapping("/user/userApi")
	public String foruser() {
		return "API for user";
	}
	@GetMapping("/admin/adminApi")
	public String foradmin() {
		return "API for admin";
	}
}
