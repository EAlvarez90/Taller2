package com.example.Taller2.Controller;

import com.example.Taller2.Modelo.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final List<Task> task = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task1){
        task.add(task1);
        return new ResponseEntity<>(task1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Task> completeTask(@PathVariable Long id){
        for (Task task1 : task){
            if (task1.getId().equals(id)){
                task1.setCompleted(true);
                return ResponseEntity.ok(task1);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}