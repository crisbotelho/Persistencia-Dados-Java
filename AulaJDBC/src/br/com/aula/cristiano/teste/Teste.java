package br.com.aula.cristiano.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.aula.cristiano.dao.ProdutoDao;
import br.com.aula.cristiano.dao.ProdutoDaoImpl;
import br.com.aula.cristiano.model.Produto;

public class Teste {

	public static void main(String[] args) {

		ProdutoDao produtoDao = null;
		try {
			produtoDao = new ProdutoDaoImpl();
			Produto produto = new Produto("Notebook", "NoteBook Preto");
			Produto produto2 = new Produto("Smartphone", "Smartphone Preto");
			Produto produto3 = new Produto("Smartphone", "Smartphone Branco");
			Produto produto4 = new Produto("Livro", "Como programar");
			Produto produto5 = new Produto("Livro", "JDBC");
			Produto produto6 = new Produto("Relógio", "Relógio de pulso");
//			produtoDao.salvar(produto);
//			produtoDao = new ProdutoDaoImpl();
//			produtoDao.salvar(produto2);
//			produtoDao = new ProdutoDaoImpl();
//			produtoDao.salvar(produto3);
//			produtoDao = new ProdutoDaoImpl();
//			produtoDao.salvar(produto4);
//			produtoDao = new ProdutoDaoImpl();
//			produtoDao.salvar(produto5);
//			produtoDao.salvar(produto6);
//			produtoDao.excluir(2);
//			produtoDao = new ProdutoDaoImpl();
			List<Produto> lista = produtoDao.listarTodos();
			
			for(int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i));
			}
			
			produtoDao = new ProdutoDaoImpl();
			Long quantidade = produtoDao.contar();
			System.out.println(quantidade);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
