package br.com.mfelipesp.angularws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mfelipesp.angularws.models.Grupo;
import br.com.mfelipesp.angularws.repositories.interfaces.GrupoRepository;
import br.com.mfelipesp.angularws.services.interfaces.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService{

	@Autowired
	GrupoRepository grupoRepository;
	
	@Override
	public List<Grupo> lstGrupos() {	
		return grupoRepository.lstGrupos();
	}
}
