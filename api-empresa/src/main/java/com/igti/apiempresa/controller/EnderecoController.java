package com.igti.apiempresa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/enderecos")
public class EnderecoController {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> listar() {		
		return new ResponseEntity<String>("teste02", HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody @Validated String entidade) {
		
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
	
}
