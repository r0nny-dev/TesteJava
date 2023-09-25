package com.r0nnydev.taskmanager.dtos.modelview;

import jakarta.validation.constraints.NotBlank;

public record PessoaModelView(Long id,@NotBlank String nome, @NotBlank String departamento, Integer totalHorasGastas) {

}
