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
import br.unifor.restful.model.EstacionamentoVO;


@Path ("/estacionamento")
public class EstacionamentoResource {

	static private Map<Integer, EstacionamentoVO> estacionamentoMap;

	static {
		estacionamentoMap = new HashMap<Integer, EstacionamentoVO>();

		EstacionamentoVO es1 = new EstacionamentoVO();
		es1.setId(1L);
		es1.setCodigo("23");

		EstacionamentoVO es2 = new EstacionamentoVO();
		es2.setId(2L);
		es2.setCodigo("78");		
		
	}

	@GET
	@Produces("application/json")
	public Collection<EstacionamentoVO> lista() {
		return new ArrayList<EstacionamentoVO>(estacionamentoMap.values());
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public EstacionamentoVO busca(@PathParam("id") Long id) {
		System.out.println("ID: "+id);		
		return estacionamentoMap.get(id.intValue());
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(EstacionamentoVO estacionamentoVO) {
		estacionamentoVO.setId(estacionamentoMap.size() + 1L);
		estacionamentoMap.put(estacionamentoVO.getId().intValue(), estacionamentoVO);
		return "Eatacionamento " + estacionamentoVO.getCodigo() + " adicionado.";

	}

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String altera(EstacionamentoVO estacionamentoVO) {

		return null;
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String remove(@PathParam("id") Long id) {
		return null;
	}

	
}
