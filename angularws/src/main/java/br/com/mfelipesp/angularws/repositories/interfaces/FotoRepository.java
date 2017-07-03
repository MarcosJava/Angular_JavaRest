package br.com.mfelipesp.angularws.repositories.interfaces;

import java.util.List;

import br.com.mfelipesp.angularws.models.Foto;


public interface FotoRepository {
	
	void cadastrarFoto(Foto foto);
	void deletarFoto(Foto foto);
	void editarFoto(Foto foto);
	List<Foto> lstFotos();
	Foto lstFotosById(int id);
	
}
