package br.unifor.bean.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.unifor.bean.DepartamentoBeanRemote;
import br.unifor.entity.Departamento;
import br.unifor.entity.Estacionamento;


@Stateless
public class DepartamentoBean implements DepartamentoBeanRemote{
	
	static private Map<Integer, Departamento> departamentoMap;

	static {
		departamentoMap = new HashMap<Integer, Departamento>();

		Departamento d1 = new Departamento();
		d1.setId(1L);
		d1.setNome("Departamento x");
		d1.setCodigo("1234");	
		departamentoMap.put(d1.getId().intValue(), d1);

		Departamento d2 = new Departamento();
		d2.setId(1L);
		d2.setNome("Departamento y");
		d2.setCodigo("4321");	
		departamentoMap.put(d2.getId().intValue(), d2);

	}


	@Override
	public Collection<Departamento> lista() {
		// TODO Auto-generated method stub
		return new ArrayList<Departamento>(departamentoMap.values());
	}


	@Override
	public String insere(Departamento departamento) {
		departamento.setId(departamentoMap.size() + 1L);
		departamentoMap.put(departamento.getId().intValue(), departamento);
		return "Departamento " + departamento.getNome() + " adicionado.";
	}


	


	@Override
	public Departamento busca(Long id) {
		System.out.println("ID: "+id);		
		return departamentoMap.get(id.intValue());
	}


	@Override
	public String altera(Departamento departamento) {
	String nome = departamento.getCodigo();
	departamento.setId(departamentoMap.size() + 1L);
	departamentoMap.put(departamento.getId().intValue(), departamento);
	return "Dep" + nome + " alterado para "+ departamento.getCodigo();
	}

	@Override
	public String remove(Long id) {
	String nome = departamentoMap.get(id.intValue()).getCodigo();
	departamentoMap.remove(id.intValue());

	return "Dep " + nome + " foi removido.";
	}

	
	
	

}
