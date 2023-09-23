package com.r0nnydev.taskmanager.dtos;


public class PessoaDTO {
	private String nome; 
	private Integer totalHorasGastas;
	private String departamento; 
	
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
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public Integer getTotalHorasGastas() {
		return totalHorasGastas;
	}
	public void setTotalHorasGastas(Integer horasGastas) {
		this.totalHorasGastas = horasGastas;
	}
	
	
}
