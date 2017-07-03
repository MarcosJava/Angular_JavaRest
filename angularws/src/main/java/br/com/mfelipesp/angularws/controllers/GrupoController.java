package br.com.mfelipesp.angularws.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfelipesp.angularws.models.Grupo;
import br.com.mfelipesp.angularws.services.interfaces.GrupoService;

@CrossOrigin
@RestController
@RequestMapping("/grupos")
public class GrupoController {
	
	private final Logger log = LoggerFactory.getLogger(GrupoController.class);
	
	@Autowired
	GrupoService grupoService;
	
	@GetMapping("/")
	public List<Grupo> getGrupos(){
		log.info("Get in Grupo");
		return grupoService.lstGrupos();
	}

}
