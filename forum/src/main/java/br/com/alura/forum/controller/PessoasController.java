package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.PessoaDto;
import br.com.alura.forum.controller.form.PessoaForm;
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

	@PostMapping
	public ResponseEntity<PessoaDto> salvar(@RequestBody PessoaForm form, UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = form.converter(form);
		pessoaRepository.save(pessoa);

		URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

		return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
	}
}
