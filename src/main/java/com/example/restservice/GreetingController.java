package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;  // Импортирование класса для создания потокобезопасных счетчиков
import org.springframework.web.bind.annotation.GetMapping;  // Импортирование аннотации для обработки HTTP GET запросов
import org.springframework.web.bind.annotation.RequestParam;  // Импортирование аннотации для получения параметров из запроса
import org.springframework.web.bind.annotation.RestController;  // Импортирование аннотации для маркировки контроллера, который обрабатывает HTTP запросы

@RestController  // Аннотация, указывающая, что класс является контроллером, который будет обрабатывать HTTP-запросы и возвращать данные в формате JSON
public class GreetingController {

    // Шаблон для приветственного сообщения с использованием параметра 'name'
    private static final String template = "Hello, %s!";

    // Потокобезопасный счетчик для генерации уникальных идентификаторов
    private final AtomicLong counter = new AtomicLong();

    // Метод, который обрабатывает GET-запросы на путь "/greeting"
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        // Формирует объект Greeting с уникальным id и приветственным сообщением
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
