package com.r0nnydev.taskmanager.dtos;

public class DepartamentoDTO {
	private String departamento;
	private Integer quantidadePessoas;
	private Integer quantidadeTarefas;
	
	public DepartamentoDTO() {}
	
	public DepartamentoDTO(String departamento) {
		this.departamento = departamento;
	}
	
	public DepartamentoDTO(String departamento, Integer quantidadePessoas, Integer quantidadeTarefas) {
		this.departamento = departamento;
		this.quantidadePessoas = quantidadePessoas;
		this.quantidadeTarefas = quantidadeTarefas;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public Integer getQuantidadePessoas() {
		return quantidadePessoas;
	}
	public void setQuantidadePessoas(Integer quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}
	public Integer getQuantidadeTarefas() {
		return quantidadeTarefas;
	}
	public void setQuantidadeTarefas(Integer quantidadeTarefas) {
		this.quantidadeTarefas = quantidadeTarefas;
	}
}
