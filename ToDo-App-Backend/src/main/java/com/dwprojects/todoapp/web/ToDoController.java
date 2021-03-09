package com.dwprojects.todoapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dwprojects.todoapp.model.ToDoItem;
import com.dwprojects.todoapp.service.ToDoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {

	@Autowired
	private ToDoService tds;
	
	@GetMapping("/api/todoitems")
	public ResponseEntity<?> fetchAllToDoItems(){
		List <ToDoItem> todoItems = tds.fetchAllToDoItems();
		
		return ResponseEntity.ok(todoItems);
	}
	
	@PostMapping("/api/todoitems")
	public ResponseEntity<?> createNewToDoItem(){
		ToDoItem tdi = tds.createNewToDoItem();
		
		return ResponseEntity.ok(tdi);
	}
	
	@PutMapping("/api/todoitems/{id}")
	public ResponseEntity<?> updateToDoItems(@PathVariable Integer id, @RequestBody ToDoItem tdi){
		// Call the Service
		tds.updateToDoItem(id, tdi);
		
		List <ToDoItem> todoItems = tds.fetchAllToDoItems();
		
		return ResponseEntity.ok(todoItems);
	}
	
	@DeleteMapping("/api/todoitems/{id}")
	public ResponseEntity<?> deleteToDoItems(@PathVariable Integer id){
		// Call the Service
		tds.deleteToDoItem(id);
		
		List <ToDoItem> todoItems = tds.fetchAllToDoItems();
		
		return ResponseEntity.ok("ok");
	}
	
}
