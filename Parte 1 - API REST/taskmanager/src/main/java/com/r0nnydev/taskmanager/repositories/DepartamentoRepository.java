package com.r0nnydev.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r0nnydev.taskmanager.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
}
