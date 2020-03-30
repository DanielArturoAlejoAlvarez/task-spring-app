package com.mediasoft.javaapps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements ITask {
	
	@Autowired
	private TaskRepository repository;

	@Override
	public List<Task> list() {
		return repository.findAll();
	}

	@Override
	public Task taskById(int id) {
		return repository.findById(id);
	}

	@Override
	public Task add(Task t) {
		return repository.save(t);
	}

	@Override
	public Task edit(Task t) {
		return repository.save(t);
	}

	@Override
	public Task delete(int id) {
		Task t = repository.findById(id);
		if(t!=null) {
			repository.delete(t);
		}
		return t;		
	}

}
