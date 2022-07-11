package pe.edu.universidad.registrarEmpleado;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cine_utp_jpa.Empleado;
import pe.edu.universidad.dto.DtoEmpleadoNuevo;

/**
 * Session Bean implementation class EJB_Empleado
 */
@Stateless
@LocalBean
public class EJB_Empleado {

    /**
     * Default constructor. 
     */
    public EJB_Empleado() {
    }
    
    public void registrarEmpleado(DtoEmpleadoNuevo dtoEmple) {
    	Empleado empleado = new Empleado();
    	empleado.setNomEmp(dtoEmple.getNom_emp_Prin()+ " " + dtoEmple.getNom_emp_Sec());
    	empleado.setApeEmp(dtoEmple.getApe_emp_Prin()+ " " + dtoEmple.getApe_emp_Sec() );
    	empleado.setCodCargo(dtoEmple.getCod_cargo());
    	empleado.setDireccionEmp(dtoEmple.getDireccion_emp());
    	empleado.setEmailEmp(dtoEmple.getDireccion_emp());
    	empleado.setFotoEmp(null);
    }
}
