package br.unifor.restful.resources;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.unifor.bean.DepartamentoBeanRemote;
import br.unifor.bean.EstacionamentoBeanRemote;
import br.unifor.restful.model.DepartamentoVO;
import br.unifor.restful.model.EmpregadoVO;
import br.unifor.restful.model.EstacionamentoVO;
import br.unifor.restful.util.MontaObjetos;

@Stateless
@Path("/estacionamento")
public class EstacionamentoResource {

	@EJB
	private EstacionamentoBeanRemote estacionamentoBean;	
	
	@GET
	@Produces("application/json")
	public Collection<EstacionamentoVO> lista() {
		return MontaObjetos.montaEstacionamentosVO(estacionamentoBean.lista());
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public EstacionamentoVO busca(@PathParam("id") Long id) {
		return MontaObjetos.montaEstacionamentoVO(estacionamentoBean.busca(id));
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(EstacionamentoVO estacionamentoVO) {
		return estacionamentoBean.insere(MontaObjetos.montaEstacionamento(estacionamentoVO));
	}

	@Path("{id}")
	 @DELETE
	 @Produces("text/plain")
	 public String remove(@PathParam("id") Long id) {
	 return estacionamentoBean.remove(id);
	 }

	 @PUT
	 @Consumes("application/json")
	 @Produces("text/plain")
	 public String altera(EstacionamentoVO estacionamentoVO) {

	 return estacionamentoBean.altera(MontaObjetos.montaEstacionamento(estacionamentoVO));
	 }
	
}

	