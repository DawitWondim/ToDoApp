package com.dwprojects.todoapp.service;

import java.util.List;
import java.util.Optional;

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
	
	public void updateToDoItem(Integer id, ToDoItem tdi)
	{
		Optional<ToDoItem> ToDoOpt = tdr.fetchAllToDoItems()
										.stream()
										.filter(item -> item.getId().equals(id))
										.findAny();
		if(ToDoOpt.isPresent())
		{
			ToDoItem item = ToDoOpt.get();
			item.setIsDone(tdi.getIsDone());
			item.setTask(tdi.getTask());
		}
	}

	public ToDoItem createNewToDoItem() {
		ToDoItem tdi = new ToDoItem();
		tdi.setIsDone(false);
		tdi = tdr.save(tdi);
		tdi.setTask("Task #" + tdi.getId());	
		return tdi;
	}

	public void deleteToDoItem(Integer id) {
		tdr.delete(id);
		
	}
}
