package com.dine.todolistapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private int ID=0;
	public void addTodo(String userID, String description, LocalDate targetDate, String status) {
		
		todos.add(new Todo(++ID, userID, description, targetDate, status));
	}
	
	public List<Todo> findByUserID(String userID) {
		Predicate<? super Todo> predicate = 
				todo -> todo.getUserID().equalsIgnoreCase(userID);
		return todos.stream().filter(predicate).toList();
	}

	public void removeTodo(int ID) {
		Predicate<? super Todo> predicate = todo -> todo.getID() == ID;
		todos.removeIf(predicate);
	}		
	
	public Todo findByID(int ID) {
		Predicate<? super Todo> predicate = todo -> todo.getID() == ID;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		removeTodo(todo.getID());
		todos.add(todo);
	}

}
