package com.course.kafka.taskevents.controller;

import com.course.kafka.taskevents.model.TaskEvent;
import com.course.kafka.taskevents.model.TaskEventType;
import com.course.kafka.taskevents.producer.TaskProducer;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskProducer taskProducer;
    private final AtomicLong idGenerator = new AtomicLong(0);

    public TaskController(TaskProducer taskProducer) {
        this.taskProducer = taskProducer;
    }

    @PostMapping
    public TaskEvent createTask(@RequestBody CreateTaskRequest request) {
        Long taskId = idGenerator.incrementAndGet();

        TaskEvent event = new TaskEvent(
                TaskEventType.TASK_CREATED,
                taskId,
                request.title()
        );

        taskProducer.send(event);

        return event;
    }

    @PutMapping("/{id}")
    public TaskEvent updateTask(
            @PathVariable Long id,
            @RequestBody CreateTaskRequest request) {

        TaskEvent event = new TaskEvent(
                TaskEventType.TASK_UPDATED,
                id,
                request.title()
        );

        taskProducer.send(event);

        return event;
    }


    @DeleteMapping("/{id}")
    public TaskEvent deleteTask(@PathVariable Long id) {

        TaskEvent event = new TaskEvent(
                TaskEventType.TASK_DELETED,
                id,
                null
        );

        taskProducer.send(event);

        return event;
    }



    public record CreateTaskRequest(String title) {}
}
