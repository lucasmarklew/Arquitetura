package br.unifor.dao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.unifor.entity.Departamento;
import br.unifor.entity.Projeto;


@Stateless
public class ProjetoDAO {
	
	
	@PersistenceContext
	private EntityManager manager;
	
	public String insere(Projeto projeto){
		try{
			manager.persist(projeto);
			return "projeto " + projeto.getNome() + " inserido";
			
		}catch (PersistenceException e) {
			return "Erro ao inserir dados " + e;
		}
	}
	
	public Collection<Projeto> lista() {
        return manager.createQuery("SELECT e FROM Projeto e").getResultList();
    }


	public Projeto busca(Long id) {
        return manager.find(Projeto.class, id);
    }
	
	public String remove(Long id) {
        try {
            Projeto projeto = manager.find(Projeto.class, id);
            manager.remove(projeto);
            return "projeto " + projeto.getNome() + " removido";
        } catch (PersistenceException e) {
            return "Erro ao remover dados" + e;
        }
    }

	public String altera(Projeto projeto) {
        try {
            Projeto projetoDetached = manager.find(Projeto.class, projeto.getId());
            Projeto projetoManaged = manager.merge(projetoDetached);

            projetoManaged.setNome(projeto.getNome());
            projetoManaged.setDescricao(projeto.getDescricao());        
            return "projeto " + projeto.getNome() + " atualizado";
        } catch (PersistenceException e) {
            return "Erro ao atualizar dados" + e;
        }
    }	

}
