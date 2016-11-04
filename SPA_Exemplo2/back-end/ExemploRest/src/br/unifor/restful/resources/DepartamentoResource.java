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
import br.unifor.restful.model.DepartamentoVO;
import br.unifor.restful.model.EmpregadoVO;
import br.unifor.restful.util.MontaObjetos;

@Stateless
@Path("departamento")
public class DepartamentoResource {
	
	@EJB
	private DepartamentoBeanRemote departamentoBean;	
	
	@GET
	@Produces("application/json")
	public Collection<DepartamentoVO> lista() {
		System.out.println("TESTE");
		return MontaObjetos.montaDepartamentosVO(departamentoBean.lista());
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public DepartamentoVO busca(@PathParam("id") Long id) {
		return MontaObjetos.montaDepartamentoVO(departamentoBean.busca(id));
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(DepartamentoVO departamentoVO) {
		return departamentoBean.insere(MontaObjetos.montaDepartamento(departamentoVO));
	}

	@Path("{id}")
	 @DELETE
	 @Produces("text/plain")
	 public String remove(@PathParam("id") Long id) {
	 return departamentoBean.remove(id);
	 }

	 @PUT
	 @Consumes("application/json")
	 @Produces("text/plain")
	 public String altera(DepartamentoVO departamentoVO) {

	 return departamentoBean.altera(MontaObjetos.montaDepartamento(departamentoVO));
	 }

}
	