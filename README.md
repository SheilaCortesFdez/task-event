# Task Events

Proyecto personal para aprender Apache Kafka con Java y Spring Boot.

## Descripción

Aplicación REST que permite crear tareas y publicar eventos en Apache Kafka. Un consumidor escucha los eventos y los muestra en la consola.

## Tecnologías

- Java
- Spring Boot
- Apache Kafka
- Docker
- Maven

## Funcionamiento

1. Se envía una petición `POST` a `/tasks`.
2. La aplicación genera un evento `TASK_CREATED`.
3. El productor publica el evento en el tópico `task-events`.
4. El consumidor recibe el evento y lo muestra en la consola.

## Probar la API

**Endpoint:** `POST /tasks`

**Body:**

```json
{
  "title": "Aprender Kafka"
}
```

Ejemplo de URL local: `http://localhost:8080/tasks`

## Objetivo de aprendizaje

Comprender la comunicación mediante eventos usando Apache Kafka, Spring Boot y una API REST.

## Estado

Proyecto de aprendizaje en desarrollo.