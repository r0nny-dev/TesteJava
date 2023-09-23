package com.r0nnydev.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r0nnydev.taskmanager.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
