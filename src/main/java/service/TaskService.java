package service;

import entity.Task;
import entity.TaskType;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskService {

    public List<Task> initListTasks() {

        Task task1 = new Task.Builder("1", "Read Version Control with Git book", TaskType.READING,
                LocalDate.of(2015, Month.JULY, 4)).addTag("git").addTag("reading").addTag("books").build();

        Task task2 = new Task.Builder("2", "Read Java 8 Lambdas book", TaskType.READING,
                LocalDate.of(2015, Month.JULY, 5)).addTag("java8").addTag("reading").addTag("books").build();

        Task task3 = new Task.Builder("3", "Write a mobile application to store my tasks", TaskType.CODING,
                LocalDate.of(2015, Month.JULY, 2)).addTag("coding").addTag("mobile").build();

        Task task4 = new Task.Builder("4", "Write a blog on Java 8 Streams", TaskType.WRITING,
                LocalDate.of(2015, Month.JULY, 1)).addTag("blogging").addTag("writing").addTag("streams").build();

        Task task5 = new Task.Builder("5", "Read Domain Driven Design book", TaskType.READING,
                LocalDate.of(2015, Month.JULY, 3)).addTag("ddd").addTag("books").addTag("reading").build();

        return Arrays.asList(task1, task2, task3, task4, task5);
    }

    public List<String> findFirst5TasksWithTypeReading(List<Task> tasks) {
        return tasks.stream().filter(t -> t.getType().equals(TaskType.READING)).limit(5)
                .sorted(Comparator.comparing(Task::getCreatedOn)).map(Task::getTitle).toList();
    }

    public Map<String, List<Task>> groupTasksById(List<Task> tasks) {
        return tasks.stream().collect(Collectors.groupingBy(Task::getId));
    }

    public Map<TaskType, List<Task>> groupTasksByType(List<Task> tasks) {
        return tasks.stream().collect(Collectors.groupingBy(Task::getType));
    }

    public Map<LocalDate, List<Task>> groupTasksByCreation(List<Task> tasks) {
        return tasks.stream().collect(Collectors.groupingBy(Task::getCreatedOn));
    }

    public Map<Boolean, List<Task>> groupTasksByIsDone(List<Task> tasks) {
        return tasks.stream().collect(Collectors.groupingBy(Task::isDone));
    }
}
