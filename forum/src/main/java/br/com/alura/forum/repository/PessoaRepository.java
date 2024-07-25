package br.com.alura.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
}
