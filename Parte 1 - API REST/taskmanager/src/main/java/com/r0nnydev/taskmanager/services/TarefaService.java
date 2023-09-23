package com.r0nnydev.taskmanager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r0nnydev.taskmanager.dtos.TarefaDTO;
import com.r0nnydev.taskmanager.entities.Tarefa;
import com.r0nnydev.taskmanager.repositories.TarefaRepository;

@Service
public class TarefaService {
	 
	@Autowired
	private TarefaRepository repository;
	
	public void saveAll(List<TarefaDTO> tarefasDTO) {
		List<Tarefa> listTarefas = new ArrayList<>();
		
		for (TarefaDTO tarefaDTO : tarefasDTO) 
			listTarefas.add(dtoToTarefa(tarefaDTO));
		
		repository.saveAll(listTarefas);
	}
	
	public Tarefa dtoToTarefa(TarefaDTO dto) {
		Tarefa tarefa = new Tarefa();
		
		tarefa.setId(dto.getId());
		tarefa.setTitulo(dto.getTitulo());
		tarefa.setDescricao(dto.getDescricao());
		tarefa.setPrazo(dto.getPrazo());
		tarefa.setDuracao(dto.getDuracao());
		tarefa.setFinalizado(dto.getFinalizado());
		tarefa.setDepartamento(dto.getDepartamento());
		tarefa.setPessoaAlocada(dto.getPessoaAlocada());
		
		return tarefa;
	}
}
