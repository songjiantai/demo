package com.example.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.JSONResult;
import com.example.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/getUser")
	public User getUser() {
		User u = new User();
		u.setName("songjiantai");
		u.setAge(18);
		u.setBirthday(new Date());
		u.setPassword("wonderss");
		
		return u;
	}
	
	@RequestMapping("/getUserJson")
	public JSONResult getUserJson() {
		User u = new User();
		u.setName("songjiantai");
		u.setAge(18);
		u.setBirthday(new Date());
		u.setPassword("wonderss");
		
		return JSONResult.ok(u);
	}
}
