package com.wilhans.model.rest.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wilhans.model.model.CursoModel;
import com.wilhans.model.service.CursoServiceInterface;

@Path("/cursos")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(MediaType.APPLICATION_JSON)
public class CursoRestFacade {

	/*
	 * Direto ao banco, sem uso de serviço
	 * 
	 * @Inject private cursoDaoImplem cursoDaoImplem;
	 * 
	 * @GET public List<cursoModel> getcursoes(){ return
	 * cursoDaoImplem.getcursoes(); }
	 */

	@Inject
	private CursoServiceInterface cursoServiceInterface;

	@GET
	public List<CursoModel> getcursos() {
		return cursoServiceInterface.getCursos();
	}

	@POST
	public CursoModel salvarcurso(CursoModel cursoModel) {
		return cursoServiceInterface.salvarCurso(cursoModel);
	}

	@PUT
	public void atualizarcurso(CursoModel cursoModel) {
		cursoServiceInterface.alterar(cursoModel);
	}
	
	@DELETE
	@Path("/{codigocurso}")
	public void excluir(@PathParam("codigocurso") Integer codigocurso) {
		CursoModel cursoModel = new CursoModel();
		cursoModel.setCodigo(codigocurso);
		cursoServiceInterface.excluir(cursoModel);
	}

}
