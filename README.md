# TASK SPRING APP (JAVA)
## Description

This repository is a Application software with JAVA, SPRING, MySQL,etc this application contains an API created with JAVA.

## Installation
Using JAVA, SPRING Framework, Web Service, JPA, MySQL Driver,etc preferably.

## DataBase
Using MySQL preferably.

## Apps
Using SPRING Tool Suite 4, Postman, Insomnia,etc to feed the api.

## Usage
```html
$ git clone https://github.com/DanielArturoAlejoAlvarez/task-spring-app.git [NAME APP] 

```
Follow the following steps and you're good to go! Important:


![alt text](https://res.infoq.com/news/2018/12/intellij-idea-2018.3/en/resources/image3-1544059141594.gif)


## Coding


### Controller


```java
...
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
...

```

### Model

```java
...
@Entity
@Table(name="tasks")
public class Task {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@Column 
	private String title;
	
	@Column 
	private String description;
	
	@Column
	private Boolean status;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
...
```

## SERVICE 

```java
...
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
...
```



## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/DanielArturoAlejoAlvarez/task-spring-app. This project is intended to be a safe, welcoming space for collaboration, and contributors are expected to adhere to the [Contributor Covenant](http://contributor-covenant.org) code of conduct.


## License

The gem is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).
