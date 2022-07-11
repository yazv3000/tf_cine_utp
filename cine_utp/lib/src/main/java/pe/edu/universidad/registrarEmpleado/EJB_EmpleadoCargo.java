package pe.edu.universidad.registrarEmpleado;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cine_utp_jpa.Cargo;
import pe.edu.universidad.dto.EmpleadoCargo;

/**
 * Session Bean implementation class EJB_EmpleadoCargo
 */
@Stateless
@LocalBean
public class EJB_EmpleadoCargo {
	@PersistenceContext(unitName = "cine_utp_jpa")
    private EntityManager em;
    
    public EJB_EmpleadoCargo() {
        // TODO Auto-generated constructor stub
    }
    
    public List<EmpleadoCargo> listarCargos(){
    	Query query = em.createNamedQuery("Cargo.findAll");
    	List<EmpleadoCargo> lst = new ArrayList<EmpleadoCargo>();
    	List<Cargo> lstCargos = query.getResultList();
    	for (Cargo cargo : lstCargos) {
			EmpleadoCargo empledoCargo = new EmpleadoCargo();
			empledoCargo.setIdEmpleadoCargo(cargo.getCodCargo());
			empledoCargo.setNombreCargo(cargo.getNomCargo());
			lst.add(empledoCargo);
		}
    	return lst;
    }
    
}
