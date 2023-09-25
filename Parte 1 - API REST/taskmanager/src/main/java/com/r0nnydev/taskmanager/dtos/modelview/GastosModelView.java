package com.r0nnydev.taskmanager.dtos.modelview;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GastosModelView(Long id, @NotBlank String nome, @NotNull Double mediaHorasGastas) {

}
