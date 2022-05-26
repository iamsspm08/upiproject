package com.sujitmaity.project.upi.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sujitmaity.project.upi.entity.UPIEntity;
import com.sujitmaity.project.upi.iservice.IUpiService;


@RestController
@RequestMapping("/upi")
public class UpiController {

	@Autowired
	IUpiService iupiservice;

	@GetMapping("id/{any}")
	public ResponseEntity<UPIEntity> getUpiUser(@PathVariable("any") String upiId){
		UPIEntity upi1= iupiservice.getUpiUser(upiId);
		return new ResponseEntity<UPIEntity> (upi1,HttpStatus.OK);
	}
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<String> CreateUpiDetail(@RequestBody UPIEntity user){
		String upi2= iupiservice.CreateUpiDetail(user);
		return new ResponseEntity<String>(upi2,HttpStatus.CREATED);
	}

	@PatchMapping ("/add2")
	public ResponseEntity<String> UpdateFirstName(@RequestBody UPIEntity firstName){
		String upi3=iupiservice.UpdateFirstName(firstName);
		return new ResponseEntity<String>(upi3,HttpStatus.CREATED);

	}
	@DeleteMapping("/user/{userId}")
	@Transactional
	public ResponseEntity<String> deleteUserId(@PathVariable("userId") String userId) {
		String upi5=iupiservice.deleteUpiId(userId);
		return new ResponseEntity<String>(upi5,HttpStatus.FOUND);
	}
	
}