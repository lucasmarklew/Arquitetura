package br.unifor.entity;

import java.io.Serializable;
import java.util.Collection;


public class Empregado implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nome;
    private String email;
    private Collection<Projeto> projetos;
    private Departamento departamento;
    private Estacionamento estacionamento;
    
    
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Estacionamento getEstacionamento() {
		return estacionamento;
	}
	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(Collection<Projeto> projetos) {
		this.projetos = projetos;
	}
		
}