package pe.edu.universidad.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cine_utp_jpa.Cliente;
import pe.edu.universidad.dto.DtoClienteConsulta;
import pe.edu.universidad.dto.DtoClienteNuevo;

/**
 * Session Bean implementation class EJBCliente
 */
@Stateless
@LocalBean
public class EJBCliente {
	@PersistenceContext(unitName = "cine_utp_jpa")
    private EntityManager em;
	
    public EJBCliente() {
        // TODO Auto-generated constructor stub
    }
    
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
			System.out.println(dto.getDireccion()+"DTO----------------------------------------");
			System.out.println(cliente.getDireccionCl()+"JPA----------------------------------------------");
			lst.add(dto);
		}
    	return lst;
    }

    public void registrarCliente(DtoClienteNuevo dtoCli) {
    	Cliente cliente = new Cliente();
		cliente.setNomCl(dtoCli.getNomClie());
		cliente.setApeCl(dtoCli.getApeClie());
		cliente.setDniCl(dtoCli.getDni());
		cliente.setEmailCl(dtoCli.getCorreo());
		cliente.setDireccionCl(dtoCli.getDireccion());
		em.persist(cliente);
    }

}
