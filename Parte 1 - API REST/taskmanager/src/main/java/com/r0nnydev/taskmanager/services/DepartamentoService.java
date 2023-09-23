package com.r0nnydev.taskmanager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r0nnydev.taskmanager.dtos.DepartamentoDTO;
import com.r0nnydev.taskmanager.entities.Departamento;
import com.r0nnydev.taskmanager.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository repository;
	
	public List<DepartamentoDTO> findAll(){
		List<DepartamentoDTO> listDepartamentoDTO = new ArrayList<>();
		
		for (Departamento departamento : repository.findAll())
			listDepartamentoDTO.add(departamentoToDTO(departamento));
		
		return listDepartamentoDTO;
	}
	
	public void saveAll(List<DepartamentoDTO> departamentosDTO) {
		List<Departamento> departamentos = new ArrayList<>();
		
		for (DepartamentoDTO departamentoDTO : departamentosDTO) 
			departamentos.add(dtoToDepartamento(departamentoDTO));
		
		repository.saveAll(departamentos);
	}
	
	
	public DepartamentoDTO getDepartamentoById(Long Id) {
		return departamentoToDTO(repository.getReferenceById(Id));
	}		
	
	public Departamento dtoToDepartamento(DepartamentoDTO departamentoDTO){
		Departamento departamento = new Departamento();
		
		departamento.setTitulo(departamentoDTO.getDepartamento());
		
		return departamento;
	}
	
	public DepartamentoDTO departamentoToDTO(Departamento departamento) {
		DepartamentoDTO dto = new DepartamentoDTO();
		
		dto.setDepartamento(departamento.getTitulo());
		dto.setQuantidadePessoas(departamento.getPessoas().size());
		dto.setQuantidadeTarefas(departamento.getTarefas().size());
		
		return dto;
	}
		
}
