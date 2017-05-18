package com.cristiano.dao;

import com.cristiano.model.Livro;

public interface LivroDao {

	void salvar(Livro livro);
	void excluir(Integer id);
	void alterar(Livro livro);
	Livro getPorId(Integer id);
}
