package br.com.mfelipesp.angularws.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebReload {
	
	private final Logger log = LoggerFactory.getLogger(WebReload.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public void index(HttpServletResponse response) {	
		
		response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
		try {
			response.sendRedirect("/index.html");
		} catch (IOException e) {
			log.error("Error ao index", e);
		}
		
    }

}