package com.mediasoft.javaapps;

import java.util.List;

public interface ITask {
	
	List<Task> list();
	Task taskById(int id);
	Task add(Task t);
	Task edit(Task t);
	Task delete(int id);

}
