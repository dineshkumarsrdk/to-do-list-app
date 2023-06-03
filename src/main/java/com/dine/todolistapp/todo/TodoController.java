package com.dine.todolistapp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("userID")
public class TodoController {
	//@Autowired
	//private TodoService todoService;
	@Autowired
	private TodoRepository todoRepository;
	@GetMapping("/todo")
	public String todoView(ModelMap model) {
		List<Todo> todo = todoRepository.findByUserID(getLoggedInUserID());
		model.addAttribute("todo", todo);
		return "todoPage";
	}
	
	@GetMapping("/add-todo")
	public String addTodoView(ModelMap model) {
		Todo todo = new Todo();
		model.put("todo", todo);
		return "addTodoPage";
	}
	
	@PostMapping("/add-todo")
	public String addTodo(@Valid Todo todo, ModelMap model, BindingResult result) {
//		if(result.hasErrors()){
//			return "addTodoPage";
//		}
		String userID = (String) model.get("userID");
		todo.setUserID(userID);
		todoRepository.save(todo);
		//todoService.addTodo(userID, todo.getDescription(), todo.getTargetDate(), todo.getStatus());
		return "redirect:/todo";//redirect to /todo url
	}
	
	@GetMapping("/delete-todo")
	public String deleteTodo(@RequestParam int ID, ModelMap model) {
		todoRepository.deleteById(ID);
		//todoService.removeTodo(ID);
		return "redirect:/todo";//redirect to /todo url
	}
	
	@GetMapping("/update-todo")
	public String updateTodoView(@RequestParam int ID, ModelMap model) {
		Todo todo = todoRepository.findById(ID).get();
		//Todo todo = todoService.findByID(ID);
		model.addAttribute("todo",todo);
		return "addTodoPage";
	}
	
	@PostMapping("/update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodoPage";
		}
		String userID = getLoggedInUserID();
		todo.setUserID(userID);
		todoRepository.save(todo);
		//todoService.updateTodo(todo);
		return "redirect:/todo";//redirect to /todo url
	}
	
	public String getLoggedInUserID() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		return authentication.getName();
	}
}
