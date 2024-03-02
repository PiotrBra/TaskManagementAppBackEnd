package com.taskmanagement.app.repository;

import com.taskmanagement.app.dao.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();
    Task findById(int id);
    Task save(Task task);
    void delete(Task task);
}
