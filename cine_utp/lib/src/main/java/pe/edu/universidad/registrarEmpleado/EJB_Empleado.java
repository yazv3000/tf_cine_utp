package pe.edu.universidad.registrarEmpleado;

import java.math.BigDecimal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import cine_utp_jpa.Empleado;
import pe.edu.universidad.dto.DtoEmpleadoNuevo;

/**
 * Session Bean implementation class EJB_Empleado
 */
@Path("EJB_Empleado")
@Stateless
@LocalBean
public class EJB_Empleado {
	
	@PersistenceContext(unitName = "cine_utp_jpa")
    private EntityManager em;
    
    public EJB_Empleado() {
    }
    
    @POST
    @Path("registrarEmpleado")
    public void registrarEmpleado(DtoEmpleadoNuevo dtoEmple) {
    	
    	Empleado empleado = new Empleado();
    	empleado.setNomEmp(dtoEmple.getNom_emp_prin()+ " " + dtoEmple.getNom_emp_sec());
    	empleado.setApeEmp(dtoEmple.getApe_emp_prin()+ " " + dtoEmple.getApe_emp_sec() );
    	empleado.setCodCargo(dtoEmple.getCod_cargo());
    	empleado.setDireccionEmp(dtoEmple.getDireccion_emp());
    	empleado.setEmailEmp(dtoEmple.getDireccion_emp());
    	empleado.setSalario(BigDecimal.valueOf(dtoEmple.getSalario()));
    	empleado.setFotoEmp(null);
    	em.persist(empleado);
    	
    }
}
