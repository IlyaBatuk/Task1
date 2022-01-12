package service;

import entity.Task;
import entity.TaskType;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class TaskService {

    public List<String> findFirst5TasksWithTypeReading(List<Task> tasks) {
        return tasks.stream()
                .filter(t -> t.getType().equals(TaskType.READING))
                .limit(5)
                .sorted(comparing(Task::getCreatedOn))
                .map(Task::getTitle)
                .toList();
    }
}
