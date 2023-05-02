package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

// import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserData;
 import com.example.demo.repository.DemoDataRepository;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	 @Autowired	
	 private DemoDataRepository demoDataRepository;

	@GetMapping(path = "/checkUser")
	public String checkUser() {
		return "demo working";
	}
	
	@PostMapping(path = "/saveUser")
	public String saveUser(@RequestBody UserData userData) {
	UserData ud = new UserData();
	ud.setName(userData.getName());
	ud.setEmailId(userData.getEmailId());
	demoDataRepository.save(ud);
	return "Save successfull";
	}
	
	@GetMapping(path = "/findUser")
	public List<UserData> findUser() {
		return demoDataRepository.findAll();
	}
	
	@GetMapping(path = "/findById")
	public Optional<UserData> findById(@RequestBody UserData ud) {
		return demoDataRepository.findById(ud.getId());
	}
	
	@PostMapping(path = "/updateData")
	public int updateData(@RequestParam String name, @RequestParam int id) {
		return demoDataRepository.updateUserData(name, id);
	}
	
	@PostMapping(path = "/deleteData")
	public String delete(@RequestParam int id) {
		 demoDataRepository.deleteById(id);
		 return "Record deleted";
	}

	
}
