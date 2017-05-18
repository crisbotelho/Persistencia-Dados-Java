package com.cristiano.dao;

import com.cristiano.model.Autor;

public interface AutorDao {

	void salvar(Autor autor);
	void excluir(Integer id);
	void alterar(Autor autor);
	Autor getPorId(Integer id);
}
