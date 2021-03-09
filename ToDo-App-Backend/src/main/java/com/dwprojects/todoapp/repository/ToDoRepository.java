package com.dwprojects.todoapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.dwprojects.todoapp.model.ToDoItem;

@Repository
public class ToDoRepository {

	private Integer idCounter = 0;
	private List<ToDoItem> ToDoItems = new ArrayList<>();
	
	public List<ToDoItem> fetchAllToDoItems(){
		
		if(ToDoItems.size() == 0)
		{
			ToDoItem item1 = new ToDoItem();
			item1.setId(++idCounter);
			item1.setIsDone(false);
			item1.setTask("Task #1");
			
			ToDoItems.add(item1);
		}
		return ToDoItems;
	}
	
	public ToDoItem save(ToDoItem tds) {
		tds.setId(++idCounter);
		ToDoItems.add(tds);
		return tds;
	}

	public void delete(Integer id) {
		ToDoItems = ToDoItems.stream()
								.filter(ToDoItem -> !ToDoItem.getId().equals(id))
								.collect(Collectors.toList());
		
	}
}
