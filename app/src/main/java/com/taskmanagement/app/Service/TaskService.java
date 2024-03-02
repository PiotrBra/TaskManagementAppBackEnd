package com.taskmanagement.app.Service;

import com.taskmanagement.app.dao.Task;
import com.taskmanagement.app.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService{

    @Autowired
    private ITaskRepository repository;

    @Override
    public List<Task> getTasks(){
        return repository.findAll();
    }
    @Override
    public Task create(Task task){
        return repository.save(task);
    }

    @Override
    public Task getTaskById(int id) {
        return repository.findById(id);
    }

    public void delete(Task task){
        repository.delete(task);
    }
}
