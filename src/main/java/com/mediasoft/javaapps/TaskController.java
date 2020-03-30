package com.mediasoft.javaapps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/tasks"})
public class TaskController {
	
	@Autowired
	private TaskService ts;
	
	@GetMapping
	public List<Task> list() {
		return ts.list();
	}
	
	@PostMapping 
	public Task add(@RequestBody Task t) {
		return ts.add(t);
	}
	
	@GetMapping(path = {"/{id}"})
	public Task listById(@PathVariable("id") int id) {
		return ts.taskById(id);
	}
	
	@PutMapping(path = {"/{id}"})
	public Task edit(@RequestBody Task t, @PathVariable("id") int id) {
		t.setId(id);
		return ts.edit(t);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public Task delete(@PathVariable("id") int id) {
		return ts.delete(id);
	}

}
