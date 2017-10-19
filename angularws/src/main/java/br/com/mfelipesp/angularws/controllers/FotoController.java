package br.com.mfelipesp.angularws.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfelipesp.angularws.models.Foto;
import br.com.mfelipesp.angularws.services.interfaces.FotoService;

@SuppressWarnings({ "rawtypes", "unchecked" })
@CrossOrigin
@RestController
@RequestMapping("/fotos")
public class FotoController {
	
	private final Logger log = LoggerFactory.getLogger(FotoController.class);
	
	@Autowired
	private FotoService fotoService;
	
	public FotoController() {
				
	}
	
	@GetMapping
    public List<Foto> getFotos() {
		log.info("Get in Foto");
		return fotoService.lstFotos();
    }
	
	@PostMapping
    public ResponseEntity saveFoto(@RequestBody Foto foto) {			
		log.info("Post Foto ::" + foto.toString());
		fotoService.cadastrarFoto(foto);
		return new ResponseEntity(foto, HttpStatus.OK);
    }
	
	@PutMapping
    public ResponseEntity alterarFoto(@RequestBody Foto foto) {
		try {
			if (foto.getId() > 0){				
				fotoService.editarFoto(foto);
				return new ResponseEntity(foto, HttpStatus.OK);				
			}
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("",e);
			return new ResponseEntity(foto, HttpStatus.BAD_REQUEST);

		}		
    }
	
	
	@DeleteMapping("/{id}")
	public void deleteFoto(@PathVariable int id) {		
		log.info("Delete Foto do id = " + id);		
		fotoService.deletarFoto(id);
	}
	
	@GetMapping("/{id}")
    public Foto getFotoById(@PathVariable(value="id", required=true) int id) {		
		log.info(String.format("Get By Id %d in Foto", id));		
		Foto f =  fotoService.lstFotosById(id);
		f.setData(new Date());
		return f;
    }

}
