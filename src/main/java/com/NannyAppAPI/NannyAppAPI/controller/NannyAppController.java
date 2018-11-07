package com.NannyAppAPI.NannyAppAPI.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NannyAppAPI.NannyAppAPI.domain.NannyApp;
import com.NannyAppAPI.NannyAppAPI.repositories.NannyAppRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/nannyApp")
public class NannyAppController {

	@Autowired
	NannyAppRepository nannyAppRepository;
	
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		Iterable<NannyApp> result = nannyAppRepository.findAll();
		return new ResponseEntity<Iterable<NannyApp>>(result, HttpStatus.OK);
	}
	
	
	@GetMapping("/{day}/{time}")
	public ResponseEntity<?> getByDayTime(@PathVariable("day") String day, @PathVariable("time") String time) {
		Iterable<NannyApp> result = new ArrayList<>();
		if("All".equals(time)) {
			result = nannyAppRepository.findByDay(day);
		};
		return new ResponseEntity<Iterable<NannyApp>>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addorUpdateTask(@RequestBody NannyApp nannyapp) {
		nannyAppRepository.save(nannyapp);
		return new ResponseEntity<String>("Task added succcessfully", HttpStatus.OK);
	}
	
	@DeleteMapping
	public void deleteTask(@RequestParam("id") Integer id) {
		nannyAppRepository.delete(id);
	}
	

}