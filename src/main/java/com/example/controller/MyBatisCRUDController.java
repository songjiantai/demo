package com.example.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.JSONResult;
import com.example.pojo.SysUser;
import com.example.service.UserService;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public JSONResult saveUser() throws Exception {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("song"+ new Date());
		user.setNickname("guo"+ new Date());
		user.setPassword("jinnnnn");
		user.setIsDelete(0);
		user.setAge(23);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return JSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public JSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("180904C2APKP9WX4");
		user.setPassword("10011001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		return JSONResult.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public JSONResult deleteUser(String userId) {
		
		userService.deleteUser(userId);
		
		return JSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public JSONResult queryUserById(String userId) {
		
		return JSONResult.ok(userService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public JSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("imooc");
		user.setNickname("imooc");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return JSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public JSONResult queryUserListPaged(Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 10;
		
		SysUser user = new SysUser();
		user.setNickname("imoocTue Sep 04 15:07:23 CST 2018");
		
		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
		
		return JSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserByIdCustom")
	public JSONResult queryUserByIdCustom(String userId) {
		
		return JSONResult.ok(userService.queryUserByIdCustom(userId));
	}
	
	@RequestMapping("/saveUserTransactional")
	public JSONResult saveUserTransactional() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("lee" + new Date());
		user.setNickname("lee" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUserTransactional(user);
		
		return JSONResult.ok("保存成功");
	}
}
