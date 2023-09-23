package com.r0nnydev.taskmanager.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.r0nnydev.taskmanager.dtos.DepartamentoDTO;
import com.r0nnydev.taskmanager.dtos.PessoaDTO;
import com.r0nnydev.taskmanager.dtos.TarefaDTO;
import com.r0nnydev.taskmanager.repositories.DepartamentoRepository;

import com.r0nnydev.taskmanager.repositories.PessoaRepository;
import com.r0nnydev.taskmanager.services.DepartamentoService;
import com.r0nnydev.taskmanager.services.PessoaService;
import com.r0nnydev.taskmanager.services.TarefaService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	
	@Autowired 
	DepartamentoRepository departamentoRepository;
	
	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private TarefaService tarefaService;

	@Override
	public void run(String... args) throws Exception {

		// Departamento Mock
		List<DepartamentoDTO> listDepartamentoDTO = new ArrayList<>();
		listDepartamentoDTO.add(new DepartamentoDTO("Financeiro"));
		listDepartamentoDTO.add(new DepartamentoDTO("Comercial"));
		listDepartamentoDTO.add(new DepartamentoDTO("Desenvolvimento"));
		
		departamentoService.saveAll(listDepartamentoDTO);
		

		// Pessoas Mock
		List<PessoaDTO> listPessoasDTO = new ArrayList<>();
		listPessoasDTO.add(new PessoaDTO("Camila", 1L));
		listPessoasDTO.add(new PessoaDTO("Pedro", 2L));
		listPessoasDTO.add(new PessoaDTO("Fabiano", 3L));
		listPessoasDTO.add(new PessoaDTO("Raquel", 3L));
		listPessoasDTO.add(new PessoaDTO("Patricia", 3L));
		listPessoasDTO.add(new PessoaDTO("Joaquim", 1L));

		pessoaService.saveAll(listPessoasDTO);
		
		// Tarefas Mock
		List<TarefaDTO> listTarefasDTO = new ArrayList<>();
		listTarefasDTO.add(new TarefaDTO(1001L, "Validar NF Janeiro", "Validar notas recebidas no mês de Janeiro",
				LocalDate.of(2022, 2, 15), 14, true, departamentoRepository.getReferenceById(1L),
				pessoaRepository.getReferenceById(1L)));

		listTarefasDTO.add(new TarefaDTO(1002L, "Bug 352", "Corrigir bug 352 na versão 1.25", LocalDate.of(2022, 5, 10), 25,
				false, departamentoRepository.getReferenceById(3L), null));

		listTarefasDTO.add(new TarefaDTO(1003L, "Liberação da versão 1.24", "Disponibilizar pacote para testes",
				LocalDate.of(2022, 2, 2), 2, false, departamentoRepository.getReferenceById(3L),
				pessoaRepository.getReferenceById(3L)));

		listTarefasDTO.add(new TarefaDTO(1004L, "Reunião A", "Reunião com cliente A para apresentação do produto",
				LocalDate.of(2022, 2, 5), 5, false, departamentoRepository.getReferenceById(2L), null));

		listTarefasDTO.add(new TarefaDTO(1005L, "Reunião final", "Fechamento contrato", LocalDate.of(2022, 3, 28), 6, false,
				departamentoRepository.getReferenceById(2L), null));
		
		listTarefasDTO.add(new TarefaDTO(1006L, "Pagamento 01/2022", "Realizar pagamento dos fornecedores", LocalDate.of(2022, 1, 31),
						6, true, departamentoRepository.getReferenceById(1L), pessoaRepository.getReferenceById(1L)));
		
		listTarefasDTO.add(new TarefaDTO(1007L, "Bug 401", "Corrigir bug 401 na versão 1.20", LocalDate.of(2022, 2, 1), 2,
				true, departamentoRepository.getReferenceById(3L), pessoaRepository.getReferenceById(4L)));
		
		listTarefasDTO.add(new TarefaDTO(1008L, "Bug 399", "Corrigir bug 399 na versão 1.20", LocalDate.of(2022, 1, 28), 6,
				true, departamentoRepository.getReferenceById(3L), pessoaRepository.getReferenceById(5L)));
		
		listTarefasDTO.add(new TarefaDTO(1009L, "Reunião B", "Reunião com cliente B para apresentação do produto",
				LocalDate.of(2022, 1, 31), 5, true, departamentoRepository.getReferenceById(2L),
				pessoaRepository.getReferenceById(2L)));
		
		listTarefasDTO.add(new TarefaDTO(1010L, "Validar NF Fevereiro", "Validar notas recebidas no mês de Fevereiro",
				LocalDate.of(2022, 3, 15), 14, false, departamentoRepository.getReferenceById(1L),
				pessoaRepository.getReferenceById(6L)));
	
	
		tarefaService.saveAll(listTarefasDTO);
	}

}
