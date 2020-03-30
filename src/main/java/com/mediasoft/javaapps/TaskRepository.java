package com.mediasoft.javaapps;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface TaskRepository extends Repository<Task, Integer> {
	
	List<Task> findAll();
	Task findById(int id);
	Task save(Task t);
	void delete(Task t);
}
