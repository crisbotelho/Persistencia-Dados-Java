package com.igti.apiproduto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.igti.apiproduto.dao.ProdutoDao;
import com.igti.apiproduto.model.Produto;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	private ProdutoDao dao = new ProdutoDao();
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listar() {
		List<Produto> listaProdutos = new ArrayList<Produto>();
		return new ResponseEntity<List<Produto>>(listaProdutos, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody @Validated Produto produto) {
		dao.salvar(produto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar() {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir() {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> obterPorId(@PathVariable Integer id ) {
		Produto produto = new Produto();
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

}
