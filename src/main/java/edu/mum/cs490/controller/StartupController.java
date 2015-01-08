package edu.mum.cs490.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import edu.mum.cs490.model.Admin;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.service.AdminService;
import edu.mum.cs490.service.SystemUserService;

@Component
public class StartupController implements
		ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private AdminService adminService;
	@Autowired
	private SystemUserService userService;

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		System.out.println("Initialize admin user ");
		SystemUser user = userService.checkLogin("admin", "123");
		if (user == null) {
			Admin c = new Admin();
			c.setEmail("admin");
			c.setPassword("123");
			c.setRole("admin");
			c.setUsername("admin");
			adminService.addAdmin(c);
		}
	}
}