package br.com.mfelipesp.angularws.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfelipesp.angularws.models.Foto;

@CrossOrigin
@RestController
@RequestMapping("/fotos")
public class FotoController {
	
	private final Logger log = LoggerFactory.getLogger(FotoController.class);
	private static List<Foto> fotos = new ArrayList<Foto>();
	
	public FotoController() {
		fotos = new ArrayList<>();
		fotos.add(new Foto("Leão", "http://pt.seaicons.com/wp-content/uploads/2015/07/Young-Lion-icon.png"));
		fotos.add(new Foto("Ronaldo Fenomeno", "https://i0.wp.com/www.footballwood.com/wp-content/uploads/2013/09/Ronaldo.jpg"));
		fotos.add(new Foto("Cristiano Ronaldo", "https://lh3.googleusercontent.com/-tM_e_Q2WOhw/AAAAAAAAAAI/AAAAAAAAAAA/ynm9Ty3pEbc/photo.jpg"));
		fotos.add(new Foto("Ronaldinho Gaucho", "http://m.lance.com.br/files/mobile-article-media/uploads/2016/12/14/5851ae5759fe7.jpeg"));		
	}
	
	@GetMapping("/")
    public List<Foto> getFotos() {
		log.info("Get in Foto");
		 return fotos;
    }
	
	@PostMapping("/")
    public ResponseEntity saveFoto(@RequestBody Foto foto) {
		log.info("Post Foto");
		log.info(foto.toString());
		fotos.add(foto);
		return new ResponseEntity(foto, HttpStatus.OK);
    }

}
