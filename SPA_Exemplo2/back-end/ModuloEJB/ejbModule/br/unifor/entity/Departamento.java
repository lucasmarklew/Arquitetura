package br.unifor.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento implements Serializable {
	
private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
    private Long id;
    private String nome;
    private String codigo;
    
    @OneToMany (mappedBy="departamento")
    private Collection<Empregado> empregados;
    
	public Long getId() {
		return id;		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
	