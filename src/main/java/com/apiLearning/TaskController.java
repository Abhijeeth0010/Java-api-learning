package com.apiLearning;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	private final List<Task> tasks = new ArrayList<Task>();
	private int nextId = 1;
	
	@GetMapping
	public List<Task> getAllTasks() {
		return tasks;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable int id) {
		for (Task task : tasks) {
			if (task.getId() == id) {
				return ResponseEntity.ok(task); 
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task newTask) {
		newTask.setId(nextId++);
		tasks.add(newTask);
		return ResponseEntity.status(HttpStatus.CREATED).body(newTask);	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
		for (Task task : tasks) {
			if (task.getId() == id) {
				task.setTitle(updatedTask.getTitle());
				task.setStatus(updatedTask.isStatus());
				return ResponseEntity.ok(task);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable int id) {
		boolean removed = tasks.removeIf(task -> task.getId() == id);
		if (removed) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
