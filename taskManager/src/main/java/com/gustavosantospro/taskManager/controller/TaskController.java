package com.gustavosantospro.taskManager.controller;

import com.gustavosantospro.taskManager.model.request.TaskRequest;
import com.gustavosantospro.taskManager.model.Stage;
import com.gustavosantospro.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/createNewTask")
    public ResponseEntity createTask(@RequestBody TaskRequest taskRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(TaskRequest.toDomain(taskRequest)));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //PatchMapping vs PutMapping
    @PatchMapping
    public ResponseEntity updateStage(@RequestParam Long id, Stage stage) {
        service.updateStage(id, stage);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
