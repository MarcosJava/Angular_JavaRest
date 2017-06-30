package br.com.mfelipesp.angularws.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfelipesp.angularws.models.Foto;

@CrossOrigin
@RestController
@RequestMapping("/fotos")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class FotoController {
	
	private final Logger log = LoggerFactory.getLogger(FotoController.class);
	private static List<Foto> fotos = new ArrayList<Foto>();
	
	public FotoController() {
		fotos = new ArrayList<>();
		fotos.add(new Foto(1, "Leão", "http://pt.seaicons.com/wp-content/uploads/2015/07/Young-Lion-icon.png"));
		fotos.add(new Foto(2, "Ronaldo Fenomeno", "https://i0.wp.com/www.footballwood.com/wp-content/uploads/2013/09/Ronaldo.jpg"));
		fotos.add(new Foto(3, "Cristiano Ronaldo", "https://lh3.googleusercontent.com/-tM_e_Q2WOhw/AAAAAAAAAAI/AAAAAAAAAAA/ynm9Ty3pEbc/photo.jpg"));
		fotos.add(new Foto(4, "Ronaldinho Gaucho", "http://m.lance.com.br/files/mobile-article-media/uploads/2016/12/14/5851ae5759fe7.jpeg"));		
	}
	
	@GetMapping("/")
    public List<Foto> getFotos() {
		log.info("Get in Foto");
		 return fotos;
    }
	
	@GetMapping("/{id}")
    public Foto getFotoById(@PathVariable(value="id", required=true) int id) {		
		log.info(String.format("Get By Id %d in Foto", id));		
		return fotos.stream().filter(p -> p.getId() == id).findFirst().get();		
    }
	
	@PostMapping("/")
    public ResponseEntity saveFoto(@RequestBody Foto foto) {
		
		int id = fotos.stream()
					   .mapToInt(f -> f.getId())
					   .max()
					   .orElse(0);
		
		++id;
		foto.setId(id);
		log.info("Post Foto");
		log.info(foto.toString());
		fotos.add(foto);
		return new ResponseEntity(foto, HttpStatus.OK);
    }
	
	
	@DeleteMapping("/{id}")
	public String deleteFoto(@PathVariable int id) {		
		log.info("Delete Foto do id = " + id);		
		String retorno = "Sucesso";
		Foto foto = fotos.stream()
                .filter(f -> id == f.getId())
                .findFirst()
                .orElse(null);
		
		if(foto == null)
			retorno = "Error";
		
		log.info(foto.toString());
		fotos.remove(foto);		
		return retorno;
	}

}
