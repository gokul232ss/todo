package com.kgfsl.fixme.controller;

import com.kgfsl.fixme.model.Todo;
import com.kgfsl.fixme.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

@RequestMapping("/todolist")
public class TodoController {

	// Define the log object for this class

	@Autowired
	private TodoService todoService;

	/*@RequestMapping(method = RequestMethod.POST)
	public void addTodo(@RequestBody Todo todo) {
		System.out.println(todo);
		todoService.saveTodo(todo);
	}*/
	    @RequestMapping( method = RequestMethod.POST)

    public ResponseEntity<?> saveTodo(@RequestBody Todo todo){

        todoService.saveTodo(todo);

        return new ResponseEntity<Todo>(todo, HttpStatus.OK);

    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteTodo(@PathVariable Long id) {
		todoService.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Todo> getTodos() {
		return todoService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Todo getTodo(@PathVariable int id) {
		Todo Todo = todoService.findOne(id);
		return Todo;
	}

	    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)

    public ResponseEntity<?> updateTodo(@RequestBody Todo todo,@PathVariable("id") Long id){

        //Todo storedProduct = todo.getId(id);
		Todo t1=new Todo();
    
        t1.setName(todo.getName());
		t1.setStatus(todo.getStatus());
		t1.setPriority(todo.getPriority());
		t1.setIsCompleted(todo.getIsCompleted());

        
        todoService.updateTodo(t1,id);

        return new ResponseEntity<Todo>(todo, HttpStatus.OK);

    }

}
