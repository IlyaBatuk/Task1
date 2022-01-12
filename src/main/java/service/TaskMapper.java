package service;

import entity.Task;
import entity.TaskDto;

public class TaskMapper {

    public Task mapTaskDtoToTask(TaskDto taskDto) {
        Task task = new Task.Builder(taskDto.getId(), taskDto.getTitle(), taskDto.getType(), taskDto.getCreatedOn()).build();
        task.setTags(taskDto.getTags());
        return task;
    }

    public TaskDto mapTaskToTaskDto(Task task) {
        return new TaskDto(task.getId(), task.getTitle(), task.getType(), task.getCreatedOn(), task.getTags());
    }

}
