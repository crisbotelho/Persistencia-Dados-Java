package com.cristiano.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristiano.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

	List<Produto> findById( Integer id);
	List<Produto> findByNome( String nome);
}
