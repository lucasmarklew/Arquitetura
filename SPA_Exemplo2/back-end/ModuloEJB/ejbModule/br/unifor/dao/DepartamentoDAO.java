package br.unifor.dao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.unifor.entity.Departamento;
import br.unifor.entity.Empregado;

@Stateless
public class DepartamentoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public String insere(Departamento departamento){
		try{
			manager.persist(departamento);
			return "Departamento " + departamento.getNome() + " inserido";
			
		}catch (PersistenceException e) {
			return "Erro ao inserir dados " + e;
		}
	}
	
	public Collection<Departamento> lista() {
        return manager.createQuery("SELECT e FROM Departamento e").getResultList();
    }


	public Departamento busca(Long id) {
        return manager.find(Departamento.class, id);
    }
	
	public String remove(Long id) {
        try {
            Departamento departamento = manager.find(Departamento.class, id);
            manager.remove(departamento);
            return " " + departamento.getNome() + " removido";
        } catch (PersistenceException e) {
            return "Erro ao remover dados" + e;
        }
    }

	public String altera(Departamento departamento) {
        try {
            Departamento departamentoDetached = manager.find(Departamento.class, departamento.getId());
            Departamento departamentoManaged = manager.merge(departamentoDetached);

            departamentoManaged.setNome(departamento.getNome());
            departamentoManaged.setCodigo(departamento.getCodigo());        
            return "Departamento " + departamento.getNome() + " atualizado";
        } catch (PersistenceException e) {
            return "Erro ao atualizar dados" + e;
        }
    }	


}
