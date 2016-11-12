package br.unifor.bean.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unifor.dao.DepartamentoDAO;
import br.unifor.dao.EstacionamentoDAO;
import br.unifor.entity.Departamento;
import br.unifor.entity.Estacionamento;
import br.unifor.entity.Projeto;
import br.unifor.bean.EstacionamentoBeanRemote;

@Stateless
public class EstacionamentoBean implements EstacionamentoBeanRemote {
	
	
	@EJB
    private EstacionamentoDAO estacionamentoDAO;

    @Override
    public Collection<Estacionamento> lista() {
        return this.estacionamentoDAO.lista();
        
    }
    @Override
    public String insere(Estacionamento estacionamento) {
    this.estacionamentoDAO.insere(estacionamento);
    return "estacionamento " + estacionamento.getCodigo() + " adicionado.";
    }
    @Override
    public String remove(Long id) {
    String nome = estacionamentoDAO.busca(id).getCodigo();
    estacionamentoDAO.remove(id);

    return "estacionamento " + nome + " foi removido.";
    }
    @Override
    public Estacionamento busca(Long id) {
    System.out.println("ID: "+id);
    return estacionamentoDAO.busca(id);
    }
    @Override
    public String altera(Estacionamento estacionamento) {
    String nome = estacionamento.getCodigo();
    estacionamentoDAO.altera(estacionamento);
    return "estacionamento " + nome + " alterado para "+ estacionamento.getCodigo();
    }

	
	
	
	/*
	
	static private Map<Integer, Estacionamento> estacionamentoMap;

	static {
		estacionamentoMap = new HashMap<Integer, Estacionamento>();

		Estacionamento e1 = new Estacionamento();
		e1.setId(1L);
		e1.setCodigo("1234");	
		estacionamentoMap.put(e1.getId().intValue(), e1);

		Estacionamento e2 = new Estacionamento();
		e2.setId(2L);
		e2.setCodigo("4321");	
	
		estacionamentoMap.put(e2.getId().intValue(), e2);

	}


	@Override
	public Collection<Estacionamento> lista() {
		// TODO Auto-generated method stub
		return new ArrayList<Estacionamento>(estacionamentoMap.values());
	}


	@Override
	public String insere(Estacionamento estacionamento) {
		estacionamento.setId(estacionamentoMap.size() + 1L);
		estacionamentoMap.put(estacionamento.getId().intValue(), estacionamento);
		return "Empregado " + estacionamento.getCodigo() + " adicionado.";
	}


	


	@Override
	public Estacionamento busca(Long id) {
		System.out.println("ID: "+id);		
		return estacionamentoMap.get(id.intValue());
	}

	@Override
	public String altera(Estacionamento estacionamento) {
	String nome = estacionamento.getCodigo();
	estacionamento.setId(estacionamentoMap.size() + 1L);
	estacionamentoMap.put(estacionamento.getId().intValue(), estacionamento);
	return "Estacionamento" + nome + " alterado para "+ estacionamento.getCodigo();
	}

	@Override
	public String remove(Long id) {
	String nome = estacionamentoMap.get(id.intValue()).getCodigo();
	estacionamentoMap.remove(id.intValue());

	return "Estacionamento " + nome + " foi removido.";
	}

*/
}
