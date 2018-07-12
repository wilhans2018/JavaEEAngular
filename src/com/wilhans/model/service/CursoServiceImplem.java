package com.wilhans.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.wilhans.model.dao.CursoDaoInterface;
import com.wilhans.model.model.CursoModel;

public class CursoServiceImplem implements CursoServiceInterface {
	
	@Inject
	private CursoDaoInterface CursoDaoInterfaceImplem;

	@Override
	@Transactional
	public CursoModel salvarCurso(CursoModel CursoModel) {
		return CursoDaoInterfaceImplem.salvarCurso(CursoModel);
	}

	@Override
	@Transactional
	public void alterar(CursoModel CursoModel) {
		 CursoDaoInterfaceImplem.alterar(CursoModel);
		
	}

	@Override
	@Transactional
	public void excluir(CursoModel CursoModel) {
		CursoDaoInterfaceImplem.excluir(CursoModel);
		
	}

	@Override
	public List<CursoModel> getCursos() {
		
		return CursoDaoInterfaceImplem.getCursos();
	}

}
