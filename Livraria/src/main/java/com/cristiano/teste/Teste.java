package com.cristiano.teste;

import com.cristiano.dao.AutorDao;
import com.cristiano.dao.AutorDaoImpl;
import com.cristiano.model.Autor;
import com.cristiano.util.DataUtil;

public class Teste {

	public static void main(String[] args) {

		AutorDao autorDao = new AutorDaoImpl();
		Autor autor = new Autor();
		autor.setNome("Machado de Assis");
		autor.setEmail("machado@teste.com");
		autor.setDataNasc(DataUtil.createDate(1926, 4, 14));
		autorDao.salvar(autor);
		
	}

}
