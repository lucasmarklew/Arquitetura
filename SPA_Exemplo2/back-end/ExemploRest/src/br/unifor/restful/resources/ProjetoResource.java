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

import br.unifor.bean.EstacionamentoBeanRemote;
import br.unifor.bean.ProjetoBeanRemote;
import br.unifor.restful.model.EmpregadoVO;
import br.unifor.restful.model.EstacionamentoVO;
import br.unifor.restful.model.ProjetoVO;
import br.unifor.restful.util.MontaObjetos;

@Stateless
@Path("/projeto")
public class ProjetoResource {

	@EJB
	private ProjetoBeanRemote projetoBean;	
	
	@GET
	@Produces("application/json")
	public Collection<ProjetoVO> lista() {
		return MontaObjetos.montaProjetosVO(projetoBean.lista());
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public ProjetoVO busca(@PathParam("id") Long id) {
		return MontaObjetos.montaProjetoVO(projetoBean.busca(id));
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(ProjetoVO projetoVO) {
		return projetoBean.insere(MontaObjetos.montaProjeto(projetoVO));
	}

	@Path("{id}")
	 @DELETE
	 @Produces("text/plain")
	 public String remove(@PathParam("id") Long id) {
	 return projetoBean.remove(id);
	 }

	 @PUT
	 @Consumes("application/json")
	 @Produces("text/plain")
	 public String altera(ProjetoVO projetoVO) {

	 return projetoBean.altera(MontaObjetos.montaProjeto(projetoVO));
	 }

	
}