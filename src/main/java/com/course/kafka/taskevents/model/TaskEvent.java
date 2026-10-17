package com.course.kafka.taskevents.model;

public record TaskEvent(
        TaskEventType eventType,
        Long taskId,
        String title
) {
}
