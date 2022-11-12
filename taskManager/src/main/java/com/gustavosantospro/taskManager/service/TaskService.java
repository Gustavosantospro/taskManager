package com.gustavosantospro.taskManager.service;

import com.gustavosantospro.taskManager.model.Stage;
import com.gustavosantospro.taskManager.model.Task;
import com.gustavosantospro.taskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public void updateStage(Long id, Stage stage) {
        Task task = findById(id);
        task.setStatus(Stage.valueOf(stage.toString()));
        task.setLastModification(LocalDateTime.now());
        save(task);

    }
}
