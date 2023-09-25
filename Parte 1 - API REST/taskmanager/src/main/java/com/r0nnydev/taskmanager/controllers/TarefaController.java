package com.r0nnydev.taskmanager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r0nnydev.taskmanager.dtos.PessoaDTO;
import com.r0nnydev.taskmanager.dtos.TarefaDTO;
import com.r0nnydev.taskmanager.dtos.modelview.TarefaModelView;
import com.r0nnydev.taskmanager.entities.Tarefa;
import com.r0nnydev.taskmanager.services.PessoaService;
import com.r0nnydev.taskmanager.services.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {
	
	@Autowired
	private TarefaService service;
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/pendentes")
	public ResponseEntity<List<TarefaModelView>> findByTarefasNaoAlocadas(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getTarefasNaoAlocadas());
	}
	
	@PostMapping
	public ResponseEntity<Object> saveTarefa(@RequestBody @Valid TarefaDTO tarefaDTO) {		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tarefaDTO));
	}

	@PutMapping("/alocar/{id}")
	public ResponseEntity<Object> alocarPessoa(@PathVariable(value = "id") Long id, @RequestBody @Valid PessoaDTO pessoaDTO){
		Optional<Tarefa> tarefaO = service.findById(id);
		
		if (tarefaO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa Não Encontrada.");
		}
		
		var tarefaModel = tarefaO.get(); 
		
		if (!service.validarDepartamento(tarefaModel, pessoaDTO)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Não Pertence ao Departamento da Tarefa.");
		}
		
		tarefaModel.setPessoaAlocada(pessoaService.dtoToPessoa(pessoaDTO));
	
		return ResponseEntity.status(HttpStatus.OK).body(service.save(tarefaModel));
	}
	
	@PutMapping("/finalizar/{id}")
	public ResponseEntity<Object> finalizarTarefa(@PathVariable(value = "id") Long id){
		Optional<Tarefa> tarefaO = service.findById(id);
		
		if (tarefaO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa Não Encontrada.");
		}
		
		var tarefaModel = tarefaO.get();
		
		tarefaModel.setFinalizado(true);
		
		return ResponseEntity.status(HttpStatus.OK).body(service.save(tarefaModel));
	}
}
