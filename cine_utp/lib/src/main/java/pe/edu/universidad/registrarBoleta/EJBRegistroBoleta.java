package pe.edu.universidad.registrarBoleta;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cine_utp_jpa.Cliente;
import cine_utp_jpa.Funcion;
import pe.edu.universidad.dto.DtoClienteConsulta;
import pe.edu.universidad.dto.DtoFuncionConsulta;

/**
 * Session Bean implementation class EJBRegistroBoleta
 */
@Stateless
@LocalBean
public class EJBRegistroBoleta {

	@PersistenceContext(unitName = "cine_utp_jpa")
    private EntityManager em;
	
    public EJBRegistroBoleta() {
    }
    
    public List<DtoClienteConsulta> consultarClientes(String cadena) {
        List<DtoClienteConsulta> lst = new ArrayList<DtoClienteConsulta>();
       Query query = em.createNamedQuery("Cliente.consultarNombreDni");
       query.setParameter("cadena", "%" + cadena.toUpperCase() + "%");
       List<Cliente> lstClientes = query.getResultList();
       for (Cliente cl : lstClientes) {
    	   DtoClienteConsulta dto = new DtoClienteConsulta();
    	   dto.setIdCliente(cl.getCodCliente());
    	   dto.setNombreCompleto(cl.getNomCl() + " " + cl.getApeCl());
		   dto.setDni(cl.getDniCl());
		   dto.setEmail(cl.getEmailCl());
		   lst.add(dto);
       }
       return lst;
    }

    public List<DtoFuncionConsulta> consultarFunciones(String cadena) {
       List<DtoFuncionConsulta> lst = new ArrayList<DtoFuncionConsulta>();
       Query query = em.createNamedQuery("Funcion.consultarNombreCodigo");
       query.setParameter("cadena", "%" + cadena.toUpperCase() + "%");
       List<Funcion> lstFunciones = query.getResultList();
       for (Funcion f : lstFunciones) {
    	   DtoFuncionConsulta dto = new DtoFuncionConsulta();
    	   dto.setCodFuncion(f.getCodFuncion());
    	   dto.setNomPeli(f.getPelicula().getNomPeli());
		   dto.setFecha(f.getFechaFuncion());
		   dto.setHoraInicio(f.getHoraInicio());
		   dto.setPrecio(f.getPrecio().doubleValue());
           dto.setSala(f.getCodSala());
		   lst.add(dto);
       }
       return lst;
    }

}
