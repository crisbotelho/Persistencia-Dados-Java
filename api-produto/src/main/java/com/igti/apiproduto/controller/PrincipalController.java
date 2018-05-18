package com.igti.apiproduto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class PrincipalController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String principal() {
		return "Executando...";
	}
}
