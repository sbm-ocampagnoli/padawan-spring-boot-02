package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Pessoa;
import br.com.alura.forum.modelo.SexoPessoa;

public class PessoaForm {
	private long id;
	private String nome;
	private SexoPessoa sexo;
	private int idade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SexoPessoa getSexo() {
		return sexo;
	}

	public void setSexo(SexoPessoa sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Pessoa converter(PessoaForm form) {
		return new Pessoa(form.getNome(), form.getSexo(), form.getIdade());
	}

}
