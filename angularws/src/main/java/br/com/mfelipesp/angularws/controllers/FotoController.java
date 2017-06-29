package br.com.mfelipesp.angularws.controllers;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfelipesp.angularws.models.Foto;

@CrossOrigin
@RestController
@RequestMapping("/fotos")
public class FotoController {
	
	private final Logger log = LoggerFactory.getLogger(FotoController.class);
	
	@GetMapping("/")
    public List<Foto> getFotos() {
		log.info("Get in Foto");
		 List<Foto> fotos = new ArrayList<>();
		 fotos.add(new Foto("Leão", "http://pt.seaicons.com/wp-content/uploads/2015/07/Young-Lion-icon.png"));
		 fotos.add(new Foto("Ronaldo Fenomeno", "http://pt.seaicons.com/wp-content/uploads/2015/07/Young-Lion-icon.png"));
		 fotos.add(new Foto("Cristiano Ronaldo", "http://pt.seaicons.com/wp-content/uploads/2015/07/Young-Lion-icon.png"));
		 fotos.add(new Foto("Ronaldinho Gaucho", "http://pt.seaicons.com/wp-content/uploads/2015/07/Young-Lion-icon.png"));		
		 return fotos;
    }

}
