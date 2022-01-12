package service;

import entity.Task;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class TaskService {

    public Map<Object, List<Task>> groupTasksAny4Parameters(List<Task> tasks) {
        return tasks.stream()
                .collect(groupingBy(s -> Arrays.asList(s.getId(), s.getType(), s.getCreatedOn(), s.isDone())));
    }
}
