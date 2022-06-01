package pe.edu.universidad.registroCliente;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 * Session Bean implementation class EJBRegistroCliente
 */
@Stateless
@LocalBean
	
public class EJBRegistroCliente {
	@PersistenceContext(unitName = "cine_utp_jpa")
	private EntityManager em;
	
	public EJBRegistroCliente() {
		
	}
	
	
}
