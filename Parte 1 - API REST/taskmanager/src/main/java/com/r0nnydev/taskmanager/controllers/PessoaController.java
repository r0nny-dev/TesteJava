package com.r0nnydev.taskmanager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r0nnydev.taskmanager.dtos.PessoaDTO;
import com.r0nnydev.taskmanager.dtos.modelview.GastosModelView;
import com.r0nnydev.taskmanager.dtos.modelview.PessoaModelView;
import com.r0nnydev.taskmanager.entities.Pessoa;
import com.r0nnydev.taskmanager.services.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pessoas")
@CrossOrigin(origins = "*")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@GetMapping
	public ResponseEntity<List<PessoaModelView>> getAllPessoas() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/gastos")
	public ResponseEntity<List<GastosModelView>> getPessoasByGasto(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findGastos());
	}
	
	@PostMapping
	public ResponseEntity<Object> savePessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
		if (!service.validarDepartamento(pessoaDTO)){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Departamento Invalido");
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pessoaDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePessoa(@PathVariable(value = "id") Long id,
			@RequestBody @Valid PessoaDTO pessoaDTO) {
		Optional<Pessoa> pessoaO = service.findById(id);
		
		if (pessoaO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Não Encontrada.");
		}
		
		if (!service.validarDepartamento(pessoaDTO)){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Departamento Invalido");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(service.update(id, pessoaDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePessoa(@PathVariable(value = "id") Long id){
		Optional<Pessoa> pessoaO = service.findById(id);
		if (pessoaO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Não Encontrada.");
		}
		service.delete(pessoaO.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Pessoa Deletada com Sucesso");
	}
}
