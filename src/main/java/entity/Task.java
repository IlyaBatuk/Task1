package entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Task {

    private final String id;
    private final String title;
    private final TaskType type;
    private final LocalDate createdOn;
    private boolean done;
    private Set<String> tags;
    private LocalDate dueTo;

    public static class Builder {
        private final String id;
        private final String title;
        private final TaskType type;
        private final LocalDate createdOn;
        private final boolean done = false;
        private final Set<String> tags = new HashSet<>();

        public Builder(String id, String title, TaskType type, LocalDate createdOn) {
            this.id = id;
            this.title = title;
            this.type = type;
            this.createdOn = createdOn;
        }

        public Builder addTag(String tag) {
            tags.add(tag);
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

    private Task(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.type = builder.type;
        this.createdOn = builder.createdOn;
        this.done = builder.done;
        this.tags = builder.tags;

    }
}
