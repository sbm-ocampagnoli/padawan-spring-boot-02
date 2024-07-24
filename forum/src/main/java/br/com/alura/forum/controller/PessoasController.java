package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.PessoaDto;
import br.com.alura.forum.modelo.Pessoa;
import br.com.alura.forum.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping
	public List<PessoaDto> listar() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		return PessoaDto.converter(pessoas);
	}
}
