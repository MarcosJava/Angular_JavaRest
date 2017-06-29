package br.com.mfelipesp.angularws.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebReload {
	
	private final Logger log = LoggerFactory.getLogger(WebReload.class);
	
	@GetMapping("/")
    public String index() {	
		log.info("chegou");
		return "/index.html";		
    }

}