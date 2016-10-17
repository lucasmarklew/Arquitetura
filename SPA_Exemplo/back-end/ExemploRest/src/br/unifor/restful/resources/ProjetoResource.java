package br.unifor.restful.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.unifor.restful.model.DepartamentoVO;
import br.unifor.restful.model.ProjetoVO;



@Path("/projeto")
public class ProjetoResource {

	
	static private Map<Integer, ProjetoVO> projetoMap;

	static {
		projetoMap = new HashMap<Integer, ProjetoVO>();

		ProjetoVO p1 = new ProjetoVO();
		p1.setId(1L);
		p1.setNome("Projeto172");
		p1.setDescricao("Melhoria do financeiro");
		p1.setSelected(true);
		
		ProjetoVO p2 = new ProjetoVO();
		p2.setId(2L);
		p2.setNome("Projeto174");
		p2.setDescricao("limpeza aumoxarifado");
		p2.setSelected(true);	
		
	}

	@GET
	@Produces("application/json")
	public Collection<ProjetoVO> lista() {
		return new ArrayList<ProjetoVO>(projetoMap.values());
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public ProjetoVO busca(@PathParam("id") Long id) {
		System.out.println("ID: "+id);		
		return projetoMap.get(id.intValue());
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(ProjetoVO projetoVO) {
		projetoVO.setId(projetoMap.size() + 1L);
		projetoMap.put(projetoVO.getId().intValue(), projetoVO);
		return "Projeto " + projetoVO.getNome() + " adicionado.";

	}

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String altera(ProjetoVO projetoVO) {

		return null;
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String remove(@PathParam("id") Long id) {
		return null;
	}
	
	
}
