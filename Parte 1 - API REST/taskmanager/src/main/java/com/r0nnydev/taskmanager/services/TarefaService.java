package com.r0nnydev.taskmanager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r0nnydev.taskmanager.dtos.PessoaDTO;
import com.r0nnydev.taskmanager.dtos.TarefaDTO;
import com.r0nnydev.taskmanager.dtos.modelview.TarefaModelView;
import com.r0nnydev.taskmanager.entities.Departamento;
import com.r0nnydev.taskmanager.entities.Pessoa;
import com.r0nnydev.taskmanager.entities.Tarefa;
import com.r0nnydev.taskmanager.repositories.DepartamentoRepository;
import com.r0nnydev.taskmanager.repositories.TarefaRepository;

@Service
public class TarefaService {
	 
	@Autowired
	private TarefaRepository repository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public List<TarefaModelView> getTarefasNaoAlocadas(){
		List<TarefaModelView> listTarefas = new ArrayList<>();
		
		for (Tarefa tarefa : repository.findTarefasNaoAlocadas()) {
			listTarefas.add(tarefaToModelView(tarefa));
		}
		
		return listTarefas;
	}
	
	public TarefaModelView tarefaToModelView(Tarefa tarefa) {
		
		String pessoaAlocada = "";
		
		if (tarefa.getPessoaAlocada() != null)
			pessoaAlocada = tarefa.getPessoaAlocada().getNome();
				
				
		var modelView = new TarefaModelView(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(),
				tarefa.getPrazo(), tarefa.getDuracao(), tarefa.getFinalizado(),tarefa.getDepartamento().getTitulo(), pessoaAlocada);
		
		return modelView;
	}
	
	public Optional<Tarefa> findById(Long id) {
		return repository.findById(id);
	}
	
	public void saveAll(List<TarefaDTO> tarefasDTO) {
		List<Tarefa> listTarefas = new ArrayList<>();
		
		for (TarefaDTO tarefaDTO : tarefasDTO) 
			listTarefas.add(dtoToTarefa(tarefaDTO));
		
		repository.saveAll(listTarefas);
	}
	
	public Tarefa save(TarefaDTO tarefaDTO) {
		return repository.save(dtoToTarefa(tarefaDTO));
	}
	
	public Tarefa save(Tarefa tarefa) {
		return repository.save(tarefa);
	}
	
	public Tarefa dtoToTarefa(TarefaDTO dto) {
		Tarefa tarefa = new Tarefa();
		
		tarefa.setId(dto.getId());
		tarefa.setTitulo(dto.getTitulo());
		tarefa.setDescricao(dto.getDescricao());
		tarefa.setPrazo(dto.getPrazo());
		tarefa.setDuracao(dto.getDuracao());
		tarefa.setFinalizado(dto.getFinalizado());
		tarefa.setDepartamento(getDepartamento(dto));
		
		var pessoaAlocada = getPessoa(dto);
		
		if (pessoaAlocada != null) 			
			tarefa.setPessoaAlocada(pessoaAlocada);
		
		return tarefa;
	}
	

	public Boolean validarDepartamento(Tarefa tarefa, PessoaDTO pessoaDTO) {
		var departamentoTarefa = tarefa.getDepartamento();
		var departamentoPessoa = pessoaDTO.getIdDepartamento();
		
		Boolean valid = true;
		if (departamentoTarefa.getId() != departamentoPessoa) {
			valid = false;
		}
		
		return valid;
	}
	
	public Pessoa getPessoa(TarefaDTO dto) {
		if (dto.getIdPessoaAlocada() == null)
			return null;
		
		Optional<Pessoa> pessoaO = pessoaService.findById(dto.getIdPessoaAlocada());
		
		if (pessoaO.isPresent())
			return pessoaO.get();
		
		return null;
	}
	
	public Departamento getDepartamento(TarefaDTO dto) {
		Optional<Departamento> departamento = departamentoRepository.findById(dto.getIdDepartamento());
		
		if (departamento.isPresent())
			return departamento.get();
		
		return null;
	}
}
