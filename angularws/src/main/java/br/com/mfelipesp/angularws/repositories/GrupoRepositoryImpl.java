package br.com.mfelipesp.angularws.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.mfelipesp.angularws.models.Grupo;
import br.com.mfelipesp.angularws.repositories.interfaces.GrupoRepository;

@Component
public class GrupoRepositoryImpl implements GrupoRepository {

	
	private static List<Grupo> grupos = new ArrayList<>();
	
	public GrupoRepositoryImpl() {
		grupos.add(new Grupo(1, "Animais"));
		grupos.add(new Grupo(2, "Lugares"));
		grupos.add(new Grupo(3, "Esportes"));
	}
	
	@Override
	public List<Grupo> lstGrupos() {
		return grupos;
	}

}
