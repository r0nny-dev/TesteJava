package com.r0nnydev.taskmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.r0nnydev.taskmanager.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	@Query(value = "SELECT * FROM tb_tarefas t WHERE t.id_pessoa is null ORDER BY PRAZO ASC LIMIT 3", nativeQuery = true)
	List<Tarefa> findTarefasNaoAlocadas();
}
