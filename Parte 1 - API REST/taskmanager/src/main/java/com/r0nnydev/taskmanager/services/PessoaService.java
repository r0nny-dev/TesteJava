package com.r0nnydev.taskmanager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r0nnydev.taskmanager.dtos.PessoaDTO;
import com.r0nnydev.taskmanager.dtos.modelview.GastosModelView;
import com.r0nnydev.taskmanager.dtos.modelview.PessoaModelView;
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
	
	public List<PessoaModelView> findAll(){
		List<PessoaModelView> pessoasDTO = new ArrayList<>(); 
		
		for (Pessoa pessoa : repository.findAll()) {
			pessoasDTO.add(PessoaToModelView(pessoa));
		}
		
		return pessoasDTO;
	}
	
	public List<GastosModelView> findGastos(){
		List<GastosModelView> listGastosModelView = new ArrayList<>();
		
		for (Pessoa pessoa : repository.findAll()) {
			listGastosModelView.add(pessoaToGastosModelView(pessoa));
		}
		
		return listGastosModelView;
	}
	
	public GastosModelView pessoaToGastosModelView(Pessoa pessoa) {
		var gastosModelView = new GastosModelView(pessoa.getId(), pessoa.getNome(), getMediaHorasGastas(pessoa));
		
		return gastosModelView;
	}
	
	public Double getMediaHorasGastas(Pessoa pessoa) {
		Double valorTotal = 0d;
		
		if (pessoa != null && pessoa.getTarefas() != null) {			
			for (Tarefa tarefa : pessoa.getTarefas()) {
				valorTotal += tarefa.getDuracao();
			}
		}
		
		Double media = 0d; 
		Integer quantidade = pessoa.getTarefas().size();
		
		if (valorTotal <= 0d) {
			media = valorTotal;
		}
		
		
		if (valorTotal > 0d && quantidade != 0) {
			media = valorTotal / quantidade;
		}
		
		return media;
	}
	
	public Optional<Pessoa> findById(Long id){
		return repository.findById(id);
	}
	
	public Pessoa save(PessoaDTO pessoaDTO) {	
		return repository.save(dtoToPessoa(pessoaDTO));
	}
	
	public Pessoa save(Pessoa pessoa) {	
		return repository.save(pessoa);
	}
	
	public Pessoa update(Long id, PessoaDTO pessoaDTO) {
		
		Optional<Pessoa> pessoaO = findById(id);
		
		Pessoa pessoaModel = pessoaO.get();		
		
		pessoaModel.setDepartamento(getDepartamento(pessoaDTO));
		
		return repository.save(pessoaModel);
	}
	
	public void saveAll(List<PessoaDTO> pessoasDTO) {
		List<Pessoa> pessoas = new ArrayList<>();
		
		for (PessoaDTO pessoaDTO : pessoasDTO) 
			pessoas.add(dtoToPessoa(pessoaDTO));
		
		repository.saveAll(pessoas);
	}

	public void delete(Pessoa pessoa) {
		repository.delete(pessoa);
	}
	
	public PessoaModelView PessoaToModelView(Pessoa pessoa) {
		var pessoaModelView = new PessoaModelView(pessoa.getId(), pessoa.getNome(),
				pessoa.getDepartamento().getTitulo(), getTotalHorasGastas(pessoa));
				
		return pessoaModelView;
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
	
	public Boolean validarDepartamento(PessoaDTO dto) {
		var departamento = getDepartamento(dto);
		
		Boolean valid = true;
		if (departamento == null) {
			valid = false;
		}
		
		return valid;
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
