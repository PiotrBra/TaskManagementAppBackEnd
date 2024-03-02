package com.taskmanagement.app.Controller;


import com.taskmanagement.app.Service.TaskService;
import com.taskmanagement.app.dao.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
    @Autowired
    private TaskService service;



    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return service.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable(value = "id") int id){
        return service.getTaskById(id);
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestParam(value = "name") String name,
                        @RequestParam(value = "description") String description,
                        @RequestParam(value = "status") String status){
        return service.create(new Task(name, description, status));
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable(value = "id") int id,
                                                         @RequestParam(value = "name") String name,
                                                         @RequestParam(value = "description") String description,
                                                         @RequestParam(value = "status") String status){
        Task task = service.getTaskById(id);
        if (task != null){
            task.setName(name);
            task.setDescription(description);
            task.setStatus(status);
            return service.create(task);
        }
        return null;
    }
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Map<String,String>> deleteTask(@PathVariable(value = "id") int id){
        Task task = service.getTaskById(id);
        if(task == null){
            Map<String,String> json = Map.of("messege", "Task not found");
            return new ResponseEntity<>(json, HttpStatus.NOT_FOUND);
        }
        service.delete(task);
        Map<String,String> json = Map.of("messege", "Task deleted");
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

}
