package com.wilhans.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.wilhans.model.dao.ProfessorDaoInterface;
import com.wilhans.model.model.ProfessorModel;

public class ProfessorServiceImplem implements ProfessorServiceInterface {
	
	@Inject
	private ProfessorDaoInterface professorDaoInterfaceImplem;

	@Override
	@Transactional
	public ProfessorModel salvarProfessor(ProfessorModel professorModel) {
		return professorDaoInterfaceImplem.salvarProfessor(professorModel);
	}

	@Override
	@Transactional
	public void alterar(ProfessorModel professorModel) {
		 professorDaoInterfaceImplem.alterar(professorModel);
		
	}

	@Override
	@Transactional
	public void excluir(ProfessorModel professorModel) {
		professorDaoInterfaceImplem.excluir(professorModel);
		
	}

	@Override
	public List<ProfessorModel> getProfessores() {
		
		return professorDaoInterfaceImplem.getProfessores();
	}

}
