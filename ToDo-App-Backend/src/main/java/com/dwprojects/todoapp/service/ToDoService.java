package com.dwprojects.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dwprojects.todoapp.model.ToDoItem;
import com.dwprojects.todoapp.repository.ToDoRepository;

@Service
public class ToDoService {
	
	@Autowired
	ToDoRepository tdr;
	
	public List<ToDoItem> fetchAllToDoItems(){
		return tdr.fetchAllToDoItems();
	}
}
