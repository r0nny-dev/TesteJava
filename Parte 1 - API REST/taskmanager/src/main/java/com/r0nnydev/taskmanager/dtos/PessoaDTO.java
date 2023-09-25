package com.r0nnydev.taskmanager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PessoaDTO {

	@NotBlank
	private String nome;
	
	@NotNull
	private Long idDepartamento; 
		
	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public PessoaDTO() {}
	
	public PessoaDTO(String nome, Long idDepartamento) {
		this.nome = nome;
		this.idDepartamento = idDepartamento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
