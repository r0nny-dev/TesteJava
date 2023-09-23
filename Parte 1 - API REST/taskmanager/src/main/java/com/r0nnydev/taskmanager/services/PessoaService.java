package com.r0nnydev.taskmanager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r0nnydev.taskmanager.dtos.PessoaDTO;
import com.r0nnydev.taskmanager.entities.Departamento;
import com.r0nnydev.taskmanager.entities.Pessoa;
import com.r0nnydev.taskmanager.entities.Tarefa;
import com.r0nnydev.taskmanager.repositories.DepartamentoRepository;
import com.r0nnydev.taskmanager.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;	
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public List<PessoaDTO> findAll(){
		List<PessoaDTO> pessoasDTO = new ArrayList<>(); 
		
		for (Pessoa pessoa : repository.findAll()) {
			pessoasDTO.add(PessoaToDTO(pessoa));
		}
		
		return pessoasDTO;
	}
	
	public void saveAll(List<PessoaDTO> pessoasDTO) {
		List<Pessoa> pessoas = new ArrayList<>();
		
		for (PessoaDTO pessoaDTO : pessoasDTO) 
			pessoas.add(dtoToPessoa(pessoaDTO));
		
		repository.saveAll(pessoas);
	}

	public PessoaDTO PessoaToDTO(Pessoa pessoa) {
		PessoaDTO dto = new PessoaDTO();
		
		dto.setNome(pessoa.getNome());
		dto.setDepartamento(pessoa.getDepartamento().getTitulo());
		dto.setTotalHorasGastas(getTotalHorasGastas(pessoa));
		
		return dto;
	}
	
	public Pessoa dtoToPessoa(PessoaDTO pessoaDTO){
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setDepartamento(getDepartamento(pessoaDTO));
		
		return pessoa;
	}
	
	public Departamento getDepartamento(PessoaDTO dto) {
		Optional<Departamento> departamento = departamentoRepository.findById(dto.getIdDepartamento());
		
		if (departamento.isPresent())
			return departamento.get();
		
		return null;
	}
	
	public Integer getTotalHorasGastas(Pessoa pessoa) {
		Integer somaDasHoras = 0;
		
		if (pessoa != null && pessoa.getTarefas() != null) {			
			for (Tarefa tarefa : pessoa.getTarefas()) {
				somaDasHoras += tarefa.getDuracao();
			}
		}
		
		return somaDasHoras;
	}	
}
