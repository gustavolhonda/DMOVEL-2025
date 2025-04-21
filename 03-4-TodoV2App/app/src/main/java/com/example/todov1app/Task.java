package com.example.todov1app;

import java.io.Serializable;
import java.util.List;

public class Task implements Serializable {
    String name, description;
    Integer priority;

    public Task(String name, String description, Integer priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getNamePriority() {
        String[] namePriorities = {"low", "medium", "high"};
        if (priority == -1)
            return "error";
        return namePriorities[priority];
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return getName();
    }
}
