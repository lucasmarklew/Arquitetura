package br.unifor.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Empregado implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    
    @ManyToMany
    @JoinTable(name="empregado_projeto", joinColumns=@JoinColumn(name="empregado_id"), inverseJoinColumns=@JoinColumn(name="projeto_id"))
    private Collection<Projeto> projetos;
    
    @ManyToOne    
    @JoinColumn(name="departamento_id", referencedColumnName="id")
    private Departamento departamento;
    
    @OneToOne
    @JoinColumn (name = "ESTACIONAMENTO_ID")
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