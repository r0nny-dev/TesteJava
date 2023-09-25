package com.r0nnydev.taskmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r0nnydev.taskmanager.dtos.modelview.DepartamentoModelView;
import com.r0nnydev.taskmanager.services.DepartamentoService;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoController {
	@Autowired
	private DepartamentoService service;
	
	@GetMapping
	public List<DepartamentoModelView> getall(){
		return service.findAllModelView();
	}
}
