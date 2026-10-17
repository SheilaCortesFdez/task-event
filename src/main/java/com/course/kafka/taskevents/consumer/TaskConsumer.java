package com.course.kafka.taskevents.consumer;

import com.course.kafka.taskevents.model.TaskEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TaskConsumer {
    //@KafkaListener: le dice a Spring que escuche el topic task-events.
    //es el metodo que se ejecuta cuando llega un evento. Spring convierte el mensaje JSON a un objeto TaskEvent,
    // siempre que configuremos correctamente la deserialización.
    @KafkaListener(topics = "task-events", groupId = "task-events-group")
    public void listen(TaskEvent event) {
        System.out.println("Evento recibido: " + event);
    }
}
