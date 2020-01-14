package com.detalhe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deploy")
public class HelloController {

	@GetMapping
	@RequestMapping("/teste1")
	public String testeDeploy() {
		return "Teste de deploy ok";
	}

}
