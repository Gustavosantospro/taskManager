package com.gustavosantospro.taskManager.repository;

import com.gustavosantospro.taskManager.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
