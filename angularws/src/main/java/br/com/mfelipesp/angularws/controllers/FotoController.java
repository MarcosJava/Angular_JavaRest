package br.com.mfelipesp.angularws.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfelipesp.angularws.models.Foto;

@CrossOrigin
@RestController
@RequestMapping("/fotos")
public class FotoController {
	
	@GetMapping("/")
    public List<Foto> getFotos() {
		 List<Foto> fotos = new ArrayList<>();
		 fotos.add(new Foto("Leão", "http://pt.seaicons.com/wp-content/uploads/2015/07/Young-Lion-icon.png"));
		 fotos.add(new Foto("Leão 1", "http://pt.seaicons.com/wp-content/uploads/2015/07/Young-Lion-icon.png"));
		 fotos.add(new Foto("Leão 2", "http://pt.seaicons.com/wp-content/uploads/2015/07/Young-Lion-icon.png"));
		 fotos.add(new Foto("Leão 3", "http://pt.seaicons.com/wp-content/uploads/2015/07/Young-Lion-icon.png"));		
		 return fotos;
    }

}
