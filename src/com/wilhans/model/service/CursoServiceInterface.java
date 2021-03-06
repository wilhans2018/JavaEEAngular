package com.wilhans.model.service;

import java.util.List;

import com.wilhans.model.model.CursoModel;

public interface CursoServiceInterface {
	
	CursoModel salvarCurso(CursoModel CursoModel);
	
	void alterar(CursoModel CursoModel);
	
	void excluir(CursoModel CursoModel);
	
	List<CursoModel> getCursos();

}
