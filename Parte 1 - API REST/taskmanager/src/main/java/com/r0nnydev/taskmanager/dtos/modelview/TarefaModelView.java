package com.r0nnydev.taskmanager.dtos.modelview;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TarefaModelView(Long id,@NotBlank String titulo, @NotBlank String descricao, @NotNull LocalDate prazo, @NotNull Integer duracao,
		Boolean finalizado,@NotBlank String departamento, String pessoaAlocada) {
}
