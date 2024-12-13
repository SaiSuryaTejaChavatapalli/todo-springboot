package com.sst.TodoSpringBoot;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable Long todoId ){
        for(Todo todo:todos){
            if(todo.getId()==todoId){
                return ResponseEntity.status(HttpStatus.OK).body(todo);
            }
        }
        // Prepare a JSON response for 404 Not Found
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Todo with ID " + todoId + " not found");
        response.put("status", HttpStatus.NOT_FOUND.value());

        // Return 404 with JSON response
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

}
