package br.com.alura.forum.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Pessoa;
import br.com.alura.forum.modelo.SexoPessoa;

public class PessoaDto {
	
	private String nome;
	private SexoPessoa sexo;

	public PessoaDto(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.sexo = pessoa.getSexo();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public SexoPessoa getSexo() {
		return sexo;
	}

	public void setSexo(SexoPessoa sexo) {
		this.sexo = sexo;
	}

	public static List<PessoaDto> converter(List<Pessoa> pessoas) {
		return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
	}

}
