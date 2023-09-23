package com.r0nnydev.taskmanager.dtos;

import java.time.LocalDate;

import com.r0nnydev.taskmanager.entities.Departamento;
import com.r0nnydev.taskmanager.entities.Pessoa;

public class TarefaDTO {
	private Long id;
	private String titulo;
	private String descricao;
	private LocalDate prazo;
	private Integer duracao;
	private Boolean finalizado;
	private Pessoa pessoaAlocada;
	private Departamento departamento;

	public TarefaDTO(Long id, String titulo, String descricao, LocalDate prazo, Integer duracao, Boolean finalizado,
			Departamento departamento, Pessoa pessoaAlocada) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prazo = prazo;
		this.duracao = duracao;
		this.finalizado = finalizado;
		this.departamento = departamento;
		this.pessoaAlocada = pessoaAlocada;
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

	public Pessoa getPessoaAlocada() {
		return pessoaAlocada;
	}

	public void setPessoaAlocada(Pessoa pessoaAlocada) {
		this.pessoaAlocada = pessoaAlocada;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
