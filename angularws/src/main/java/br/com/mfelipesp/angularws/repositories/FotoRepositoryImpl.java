package br.com.mfelipesp.angularws.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.mfelipesp.angularws.models.Foto;
import br.com.mfelipesp.angularws.models.Grupo;
import br.com.mfelipesp.angularws.repositories.interfaces.FotoRepository;

@Component
public class FotoRepositoryImpl implements FotoRepository{

	private static List<Foto> fotos = new ArrayList<Foto>();
	
	public FotoRepositoryImpl() {
		fotos = new ArrayList<>();
		fotos.add(new Foto(1, "Leão", "http://pt.seaicons.com/wp-content/uploads/2015/07/Young-Lion-icon.png", new Grupo(1, "Animal")));
		fotos.add(new Foto(2, "Ronaldo Fenomeno", "https://i0.wp.com/www.footballwood.com/wp-content/uploads/2013/09/Ronaldo.jpg", new Grupo(2, "Jogador")));
		fotos.add(new Foto(3, "Cristiano Ronaldo", "https://lh3.googleusercontent.com/-tM_e_Q2WOhw/AAAAAAAAAAI/AAAAAAAAAAA/ynm9Ty3pEbc/photo.jpg", new Grupo(1, "Animal")));
		fotos.add(new Foto(4, "Ronaldinho Gaucho", "http://m.lance.com.br/files/mobile-article-media/uploads/2016/12/14/5851ae5759fe7.jpeg", new Grupo(2, "Jogador")));
	}
	
	@Override
	public void cadastrarFoto(Foto foto) {
		fotos.add(foto);
		
	}

	@Override
	public void deletarFoto(Foto foto) {
		fotos.remove(foto);
	}

	@Override
	public void editarFoto(Foto foto) {
		Foto fotoAntiga = fotos.stream()
                .filter(f -> foto.getId() == f.getId())
                .findFirst()
                .orElse(null);
		
		fotos.remove(fotoAntiga);
		fotos.add(foto);
	}
		

	@Override
	public List<Foto> lstFotos() {		
		return fotos;
	}

	@Override
	public Foto lstFotosById(int id) {
		return fotos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);		
	}

}
