package com.desafio.gerenciador.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.desafio.gerenciador.domain.tasks.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
}
