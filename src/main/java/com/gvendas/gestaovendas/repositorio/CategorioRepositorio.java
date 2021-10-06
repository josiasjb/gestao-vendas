package com.gvendas.gestaovendas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvendas.gestaovendas.entidades.Categoria;

public interface CategorioRepositorio extends JpaRepository<Categoria, Long> {
	
	Categoria findByNome(String nome);
	
}
