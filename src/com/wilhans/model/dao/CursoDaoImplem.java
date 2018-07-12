package com.wilhans.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.wilhans.model.model.CursoModel;

public class CursoDaoImplem implements CursoDaoInterface {

	@PersistenceContext(unitName = "Projeto4FinalPersistenceUnit")
	private EntityManager entityManager;

	@Override
	public CursoModel salvarCurso(CursoModel CursoModel) {
		entityManager.persist(CursoModel);
		return CursoModel;
	}

	@Override
	public void alterar(CursoModel CursoModel) {
		CursoModel CursoModelMerge = entityManager.merge(CursoModel);
		entityManager.persist(CursoModelMerge);

	}

	@Override
	public void excluir(CursoModel CursoModel) {
		CursoModel CursoModelMerge = entityManager.merge(CursoModel);
		entityManager.remove(CursoModelMerge);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CursoModel> getCursos() {
		Query query = entityManager.createQuery("from CursoModel");	
		return query.getResultList();
	}

}
