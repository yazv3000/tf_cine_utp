package pe.edu.universidad.rs;

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

/**
 * Session Bean implementation class EJBDaoGenerico
 */
@Path("EJBDaoGenerico")		// para que sea servicio rest
@Stateless
@LocalBean
public class EJBDaoGenerico {

	@PersistenceContext(unitName = "cine_utp_jpa")
    private EntityManager em2;
    
    /**
     * Default constructor. 
     */
    public EJBDaoGenerico() {
        System.out.println("Creando EJBDaoGenerico");
    }

    @Path("{entidad}/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object consultarEntityPorId(@PathParam(value = "entidad") String entidad, @PathParam(value = "id") int id) {
        
        Class classEntidad = null;		// objeto de tipo clase
        Object obj = null;
        
        try {
        	classEntidad = Class.forName("cine_utp_jpa."+entidad);
        	obj = em2.find(classEntidad, id);
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        return obj;
    }
    
}