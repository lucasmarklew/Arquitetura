package br.unifor.dao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.unifor.entity.Empregado;


@Stateless
public class EmpregadoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public String insere(Empregado empregado){
		try{
			manager.persist(empregado);
			return "Empregado " + empregado.getNome() + " inserido";
			
		}catch (PersistenceException e) {
			return "Erro ao inserir dados " + e;
		}
	}
	
	public Collection<Empregado> lista() {
        return manager.createQuery("SELECT e FROM Empregado e").getResultList();
    }


	public Empregado busca(Long id) {
        return manager.find(Empregado.class, id);
    }
	
	public String remove(Long id) {
        try {
            Empregado empregado = manager.find(Empregado.class, id);
            manager.remove(empregado);
            return "Empregado " + empregado.getNome() + " removido";
        } catch (PersistenceException e) {
            return "Erro ao remover dados" + e;
        }
    }

	public String altera(Empregado empregado) {
        try {
            Empregado empregadoDetached = manager.find(Empregado.class, empregado.getId());
            Empregado empregadoManaged = manager.merge(empregadoDetached);

            empregadoManaged.setNome(empregado.getNome());
            empregadoManaged.setEmail(empregado.getEmail());        
            return "Empregado " + empregado.getNome() + " atualizado";
        } catch (PersistenceException e) {
            return "Erro ao atualizar dados" + e;
        }
    }	
}
