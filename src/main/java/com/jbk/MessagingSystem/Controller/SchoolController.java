package com.jbk.MessagingSystem.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.MessagingSystem.Bean.School;
import com.jbk.MessagingSystem.Services.SchoolServiceImpl;

import lombok.val;
import lombok.experimental.Delegate;

@RestController
@RequestMapping("school")
public class SchoolController {
	@Autowired
	SchoolServiceImpl schoolServiceImpl;
	@RequestMapping("/hello")
	public String show() {
		return"hello";
	}
	@GetMapping("/byid/{sid}")
	ResponseEntity<?> getById(@PathVariable("sid")int  school_id){
		System.out.println("controller");
		return new ResponseEntity<School>(schoolServiceImpl.getById( school_id), HttpStatus.OK);
		
	}
	@PostMapping("/add")
	public ResponseEntity<?> addSchool(@Valid @RequestBody School school, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
			
		}else {
		schoolServiceImpl.addSchool(school);
		return new ResponseEntity<School>(HttpStatus.OK);
		}
		
	}
	@PutMapping("/update/{sid}")
	public ResponseEntity<?> updateSchool(@RequestBody School school, @PathVariable("sid")int  school_id) {
		return new ResponseEntity<School>(schoolServiceImpl.updateSchool(school,  school_id), HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{sid}")
	public ResponseEntity<?> deleteSchool(@PathVariable("sid")int  school_id){
		schoolServiceImpl.deleteSchool( school_id);
		return new ResponseEntity<School>(HttpStatus.OK);
		
	}

	
	

}
