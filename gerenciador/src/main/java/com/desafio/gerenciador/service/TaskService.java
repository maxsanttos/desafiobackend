package com.desafio.gerenciador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desafio.gerenciador.domain.repository.TaskRepository;
import com.desafio.gerenciador.domain.tasks.Task;
import com.desafio.gerenciador.domain.tasks.dto.TaskDTO;
import com.desafio.gerenciador.exception.TaskNotFoundException;



@Service
public class TaskService {
    
    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService){
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(TaskDTO taskDTO){
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, TaskDTO taskDTO){

        if (id == null || taskDTO == null) {
            throw new IllegalArgumentException("id e taskDTO não devem ser nulos");
        }

        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setTitle(taskDTO.getTitle());
            existingTask.setDescription(taskDTO.getDescription());
            existingTask.setStatus(taskDTO.getStatus());
            return taskRepository.save(existingTask);
        }else{
            throw new TaskNotFoundException("Tarefa com id " + id + " não encontrada");
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
