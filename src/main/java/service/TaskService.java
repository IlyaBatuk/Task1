package service;

import entity.Task;
import entity.TaskType;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class TaskService {

    public List<Task> initListTasks() {

        Task task1 = new Task.Builder("1", "Read Version Control with Git book", TaskType.READING,
                LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books").build();

        Task task2 = new Task.Builder("2", "Read Java 8 Lambdas book", TaskType.READING,
                LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books").build();

        Task task3 = new Task.Builder("3", "Write a mobile application to store my tasks", TaskType.CODING,
                LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile").build();

        Task task4 = new Task.Builder("4", "Write a blog on Java 8 Streams", TaskType.WRITING,
                LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams").build();

        Task task5 = new Task.Builder("5", "Read Domain Driven Design book", TaskType.READING,
                LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading").build();

        return Arrays.asList(task1, task2, task3, task4, task5);
    }
}