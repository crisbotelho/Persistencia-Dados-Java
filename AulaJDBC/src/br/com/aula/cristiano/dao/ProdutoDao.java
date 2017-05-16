package br.com.aula.cristiano.dao;

import java.util.List;

import br.com.aula.cristiano.model.Produto;

public interface ProdutoDao {

	void salvar(Produto produto);
	
	void excluir(int id);
	
	void atualizar(Produto produto);
	
	List<Produto> listarTodos();
	
	Produto obterPorId(int id);
	
	Long contar();
}
