package com.cristiano.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristiano.model.Imagem;

public interface ImagemRepository extends CrudRepository<Imagem, Integer> {

	List<Imagem> findByTipo(String tipo);
	
}
