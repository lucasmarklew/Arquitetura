package br.unifor.bean.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.unifor.bean.EmpregadoBeanRemote;
import br.unifor.entity.Departamento;
import br.unifor.entity.Empregado;
import br.unifor.entity.Estacionamento;
import br.unifor.entity.Projeto;

@Stateless
public class EmpregadoBean implements EmpregadoBeanRemote {

static private Map<Integer, Empregado> empregadosMap;

static {
empregadosMap = new HashMap<Integer, Empregado>();

Empregado e1 = new Empregado();
e1.setId(1L);
e1.setNome("Maria da Silva");
e1.setEmail("maria@mail.com");
e1.setDepartamento(new Departamento());
e1.setProjetos(new ArrayList<Projeto>());
e1.setEstacionamento(new Estacionamento());
empregadosMap.put(e1.getId().intValue(), e1);

Empregado e2 = new Empregado();
e2.setId(2L);
e2.setNome("João dos Santos");
e2.setEmail("joao@mail.com");
e2.setDepartamento(new Departamento());
e2.setProjetos(new ArrayList<Projeto>());
e2.setEstacionamento(new Estacionamento());
empregadosMap.put(e2.getId().intValue(), e2);

}


@Override
public Collection<Empregado> lista() {
// TODO Auto-generated method stub
return new ArrayList<Empregado>(empregadosMap.values());
}


@Override
public String insere(Empregado empregado) {
empregado.setId(empregadosMap.size() + 1L);
empregadosMap.put(empregado.getId().intValue(), empregado);
return "Empregado " + empregado.getNome() + " adicionado.";
}


@Override
public String remove(Long id) {
String nome = empregadosMap.get(id.intValue()).getNome();
empregadosMap.remove(id.intValue());

return "Empregado " + nome + " foi removido.";
}


@Override
public Empregado busca(Long id) {
System.out.println("ID: "+id);
return empregadosMap.get(id.intValue());
}


@Override
public String altera(Empregado empregado) {
String nome = empregado.getNome();
empregado.setId(empregadosMap.size() + 1L);
empregadosMap.put(empregado.getId().intValue(), empregado);
return "Empregado " + nome + " alterado para "+ empregado.getNome();
}
}
