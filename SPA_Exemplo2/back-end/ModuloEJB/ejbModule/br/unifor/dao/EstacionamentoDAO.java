package br.unifor.dao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.unifor.entity.Departamento;
import br.unifor.entity.Estacionamento;


@Stateless
public class EstacionamentoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public String insere(Estacionamento estacionamento){
		try{
			manager.persist(estacionamento);
			return "estacionamento " + estacionamento.getCodigo() + " inserido";
			
		}catch (PersistenceException e) {
			return "Erro ao inserir dados " + e;
		}
	}
	
	public Collection<Estacionamento> lista() {
        return manager.createQuery("SELECT e FROM Estacionamento e").getResultList();
    }


	public Estacionamento busca(Long id) {
        return manager.find(Estacionamento.class, id);
    }
	
	public String remove(Long id) {
        try {
            Estacionamento estacionamento = manager.find(Estacionamento.class, id);
            manager.remove(estacionamento);
            return " " + estacionamento.getCodigo() + " removido";
        } catch (PersistenceException e) {
            return "Erro ao remover dados" + e;
        }
    }

	public String altera(Estacionamento estacionamento) {
        try {
            Estacionamento estacionamentoDetached = manager.find(Estacionamento.class, estacionamento.getId());
            Estacionamento estacionamentoManaged = manager.merge(estacionamentoDetached);

            estacionamentoManaged.setCodigo(estacionamento.getCodigo());
    
            return "estacionamento " + estacionamento.getCodigo() + " atualizado";
        } catch (PersistenceException e) {
            return "Erro ao atualizar dados" + e;
        }
    }	
	
}
