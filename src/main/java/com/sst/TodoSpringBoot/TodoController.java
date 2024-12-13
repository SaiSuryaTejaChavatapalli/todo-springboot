package com.sst.TodoSpringBoot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private static List<Todo> todos;

    public TodoController() {
      todos= new ArrayList<>();
        todos.add(new Todo(1,"Bath",1,false));
        todos.add(new Todo(2,"Wash",2,true));
    }

    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todos;
    }

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo newTodo){
        todos.add(newTodo);
        return  newTodo;
    }

}
