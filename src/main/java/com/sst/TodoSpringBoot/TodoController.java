package com.sst.TodoSpringBoot;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Todo>>  getTodos(){
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/todos")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        todos.add(newTodo);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newTodo) ;
    }

}
