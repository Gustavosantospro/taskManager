package com.gustavosantospro.taskManager.model.request;

import com.gustavosantospro.taskManager.model.Stage;
import com.gustavosantospro.taskManager.model.Task;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity(name = "task")
public class TaskRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Stage status;
    private LocalDateTime initDate;
    private LocalDateTime conclusionDate;


    public static Task toDomain(TaskRequest request) {
        return Task.builder()
                .description(request.description)
                .status(Stage.valueOf(request.status.toString()))
                .initDate(request.initDate)
                .name(request.name)
                .conclusionDate(request.conclusionDate)
                .build();
    }
}
