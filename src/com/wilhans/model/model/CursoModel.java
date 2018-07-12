package com.wilhans.model.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "curso")
public class CursoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	// PROPRIEDADES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cur_codigo")
	Integer codigo;
	
	@Column(name="cur_descricao", length=200, nullable=false)
	String descricao;
	
	@Column(name="cur_diashorarios", length=200, nullable=true)
	String diashorarios;
	
	@ManyToOne
	@JoinColumn(name="prof_codigo", referencedColumnName="prof_codigo")
	ProfessorModel professor;

	// CONSTRUTORES
	public CursoModel() {
	}

	public CursoModel(Integer codigo, String descricao, String diashorarios, ProfessorModel professor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.diashorarios = diashorarios;
		this.professor = professor;
	}

	// GETS OF SETS
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDiashorarios() {
		return diashorarios;
	}

	public void setDiashorarios(String diashorarios) {
		this.diashorarios = diashorarios;
	}

	public ProfessorModel getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorModel professor) {
		this.professor = professor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoModel other = (CursoModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
