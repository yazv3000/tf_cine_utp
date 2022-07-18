package pe.edu.universidad.ejbgenerico;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("EJBGenerico")
@Stateless
@LocalBean
public class EJBGenerico {
	@PersistenceContext(unitName = "cine_utp_jpa")
	private EntityManager em;
    /**
     * Default constructor. 
     */
	@GET
	@Path("{entidad}/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object consultarFuncionporId(@PathParam(value="entidad") String entidad,@PathParam(value="id") int id) {
		Class classEntidad = null;
		try {
			classEntidad = Class.forName("cine_utp_jpa."+entidad);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		Object obj = em.find(classEntidad, id);
		return obj;
	}
}
