package com.dwprojects.todoapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dwprojects.todoapp.model.ToDoItem;

@Repository
public class ToDoRepository {

	private List<ToDoItem> ToDoItems = new ArrayList<>();
	
	public List<ToDoItem> fetchAllToDoItems(){
		return ToDoItems;
	}
}
