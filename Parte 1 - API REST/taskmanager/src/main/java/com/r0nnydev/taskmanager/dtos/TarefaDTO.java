package com.r0nnydev.taskmanager.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TarefaDTO {
	private Long id;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private LocalDate prazo;
	
	@NotNull
	private Integer duracao;
	private Boolean finalizado;
	
	private Long idPessoaAlocada;
	private Long idDepartamento;

	public TarefaDTO(Long id, String titulo, String descricao, LocalDate prazo, Integer duracao, Boolean finalizado,
			Long idDepartamento, Long idPessoaAlocada) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prazo = prazo;
		this.duracao = duracao;
		this.finalizado = finalizado;
		this.idDepartamento = idDepartamento;
		this.idPessoaAlocada = idPessoaAlocada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getPrazo() {
		return prazo;
	}

	public void setPrazo(LocalDate prazo) {
		this.prazo = prazo;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Long getIdPessoaAlocada() {
		return idPessoaAlocada;
	}

	public void setIdPessoaAlocada(Long idPessoaAlocada) {
		this.idPessoaAlocada = idPessoaAlocada;
	}

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
}
