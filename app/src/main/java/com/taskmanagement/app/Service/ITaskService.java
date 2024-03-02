package com.taskmanagement.app.Service;

import com.taskmanagement.app.dao.Task;

import java.util.List;

public interface ITaskService {
    public List<Task> getTasks();
    public Task create(Task task);
    public Task getTaskById(int id);
}
