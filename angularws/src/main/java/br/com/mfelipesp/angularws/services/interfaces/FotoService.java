package br.com.mfelipesp.angularws.services.interfaces;

import java.util.List;

import br.com.mfelipesp.angularws.models.Foto;

public interface FotoService {
	
	void cadastrarFoto(Foto foto);
	void deletarFoto(int id);
	void editarFoto(Foto foto) throws Exception;
	List<Foto> lstFotos();
	Foto lstFotosById(int id);

}
