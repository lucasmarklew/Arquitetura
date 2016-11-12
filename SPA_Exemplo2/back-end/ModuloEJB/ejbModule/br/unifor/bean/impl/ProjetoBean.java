package br.unifor.bean.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unifor.bean.ProjetoBeanRemote;
import br.unifor.dao.DepartamentoDAO;
import br.unifor.dao.ProjetoDAO;
import br.unifor.entity.Departamento;
import br.unifor.entity.Empregado;
import br.unifor.entity.Projeto;

@Stateless
public class ProjetoBean implements ProjetoBeanRemote {
	
	
	@EJB
    private ProjetoDAO projetoDAO;

    @Override
    public Collection<Projeto> lista() {
        return this.projetoDAO.lista();   
    }
    
    @Override
    public String insere(Projeto projeto) {
    this.projetoDAO.insere(projeto);
    return "projeto " + projeto.getNome() + " adicionado.";
    }
    @Override
    public String remove(Long id) {
    String nome = projetoDAO.busca(id).getNome();
    projetoDAO.remove(id);

    return "projeto " + nome + " foi removido.";
    }
    
    @Override
    public Projeto busca(Long id) {
    System.out.println("ID: "+id);
    return projetoDAO.busca(id);
    }
    
    @Override
    public String altera(Projeto projeto) {
    String nome = projeto.getNome();
    projetoDAO.altera(projeto);
    return "projeto " + nome + " alterado para "+ projeto.getNome();
    }

		
	/*
	static private Map<Integer, Projeto> projetoMap;

	static {
		projetoMap = new HashMap<Integer, Projeto>();

		Projeto p1 = new Projeto();
		p1.setId(1L);
		p1.setNome("projeto x");
		projetoMap.put(p1.getId().intValue(), p1);

		Projeto p2 = new Projeto();
		p2.setId(2L);
		p2.setNome("projeto y");
			
	
		projetoMap.put(p2.getId().intValue(), p2);

	}


	@Override
	public Collection<Projeto> lista() {
		// TODO Auto-generated method stub
		return new ArrayList<Projeto>(projetoMap.values());
	}


	@Override
	public String insere(Projeto projeto) {
		projeto.setId(projetoMap.size() + 1L);
		projetoMap.put(projeto.getId().intValue(), projeto);
		return "Projeto " + projeto.getNome() + " adicionado.";
	}


	@Override
	public Projeto busca(Long id) {
		System.out.println("ID: "+id);		
		return projetoMap.get(id.intValue());
	}

	@Override
	public String altera(Projeto projeto) {
	String nome = projeto.getNome();
	projeto.setId(projetoMap.size() + 1L);
	projetoMap.put(projeto.getId().intValue(), projeto);
	return "Projeto" + nome + " alterado para "+ projeto.getNome();
	}

	@Override
	public String remove(Long id) {
	String nome = projetoMap.get(id.intValue()).getNome();
	projetoMap.remove(id.intValue());

	return "Projeto " + nome + " foi removido.";
	}
	*/
	
	

	
	
	

}
