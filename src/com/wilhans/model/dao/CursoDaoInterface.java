package com.wilhans.model.dao;

import java.util.List;

import com.wilhans.model.model.CursoModel;

public interface CursoDaoInterface {
	
	CursoModel salvarCurso(CursoModel CursoModel);
	
	void alterar(CursoModel CursoModel);
	
	void excluir(CursoModel CursoModel);
	
	List<CursoModel> getCursos();
	
	

}
