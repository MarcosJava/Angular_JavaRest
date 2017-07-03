package br.com.mfelipesp.angularws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mfelipesp.angularws.models.Foto;
import br.com.mfelipesp.angularws.repositories.interfaces.FotoRepository;
import br.com.mfelipesp.angularws.services.interfaces.FotoService;

@Service
public class FotoServiceImpl implements FotoService{
	
	@Autowired
	private FotoRepository fotoRepository;

	@Override
	public void cadastrarFoto(Foto foto) {
		List<Foto> fotos = lstFotos();
		int id = fotos.stream()
				   .mapToInt(f -> f.getId())
				   .max()
				   .orElse(0);
	
		++id;
		foto.setId(id);
		
		fotoRepository.cadastrarFoto(foto);
	}

	@Override
	public void deletarFoto(int id) {
		
		
		Foto foto = lstFotos().stream()
                .filter(f -> id == f.getId())
                .findFirst()
                .orElse(null);
		
		fotoRepository.deletarFoto(foto);
	}

	@Override
	public void editarFoto(Foto foto) throws Exception {
		if(foto.getId() == 0) throw new Exception();
		fotoRepository.editarFoto(foto);
	}

	@Override
	public List<Foto> lstFotos() {		
		return fotoRepository.lstFotos();
	}

	@Override
	public Foto lstFotosById(int id) {
		return fotoRepository.lstFotosById(id);
	}
	
	
	

}
