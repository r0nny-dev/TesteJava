package com.r0nnydev.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r0nnydev.taskmanager.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
}
