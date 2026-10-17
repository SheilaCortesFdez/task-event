package com.course.kafka.taskevents.producer;

import com.course.kafka.taskevents.model.TaskEvent;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskProducer {

    private static final String TOPIC = "task-events";

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public TaskProducer(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(TaskEvent event) {
        kafkaTemplate.send(TOPIC, event.taskId().toString(), event);
    }
}
