package pe.edu.universidad.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cine_utp_jpa.Cliente;
import pe.edu.universidad.dto.DtoClienteConsulta;
import pe.edu.universidad.dto.DtoClienteNuevo;

/**
 * Session Bean implementation class EJBCliente
 */
@Path("EJBCliente")
@Stateless
@LocalBean
public class EJBCliente {
	@PersistenceContext(unitName = "cine_utp_jpa")
    private EntityManager em;
	
    public EJBCliente() {
    }
    
    @GET
    @Path("listarClientes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DtoClienteConsulta> listarClientes(){
    	Query query = em.createNamedQuery("Cliente.findAll");
    	List<DtoClienteConsulta> lst = new ArrayList<DtoClienteConsulta>();
    	List<Cliente> lstCli = query.getResultList();
    	for (Cliente cliente : lstCli) {
    		DtoClienteConsulta dto = new DtoClienteConsulta();
			dto.setIdCliente(cliente.getCodCliente());
			dto.setNombreCompleto(cliente.getNomCl()+" "+cliente.getApeCl());
			dto.setDni(cliente.getDniCl());
			dto.setDireccion(cliente.getDireccionCl());
			dto.setEmail(cliente.getEmailCl());
			lst.add(dto);
		}
    	return lst;
    }
    
    @POST
    @Path("registrarCliente")
    public void registrarCliente(DtoClienteNuevo dtoCli) {
    	Cliente cliente = new Cliente();
		cliente.setNomCl(dtoCli.getNomCliePrin()+" " + dtoCli.getNomClieSec());
		cliente.setApeCl(dtoCli.getApeCliePrin()+ " " + dtoCli.getApeClieSec());
		cliente.setDniCl(dtoCli.getDni());
		cliente.setEmailCl(dtoCli.getCorreo());
		cliente.setDireccionCl(dtoCli.getDireccion());
		em.persist(cliente);
    }

}
