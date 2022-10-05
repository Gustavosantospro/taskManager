package com.gustavosantospro.taskManager.controller;

import com.gustavosantospro.taskManager.model.Task;
import com.gustavosantospro.taskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/createNewTask")
    public ResponseEntity createTask(@RequestBody Task task) {

        // tratamento?
        return ResponseEntity.ok(taskRepository.save(task));
    }

    @DeleteMapping("/deleteTask")
    public void deleteTask(Long id) {
        
        taskRepository.deleteById(id);
    }
}
