package pe.edu.universidad.registrarEmpleado;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import pe.edu.universidad.dto.DtoEmpleadoNuevo;
import pe.edu.universidad.dto.EmpleadoCargo;

@Named
@SessionScoped
public class BeanEmpleadoNuevo implements Serializable{
	
	//ENTIDADES
	private DtoEmpleadoNuevo dtoEmpladoNuevo;
	@EJB
	private EJB_EmpleadoCargo ejbEmpleadoCargos;
	//LISTAS
	private List<EmpleadoCargo> lstCargos;

	@EJB
	private EJB_Empleado ejbEmpleado;
	
	
	public BeanEmpleadoNuevo() {}
	
	@PostConstruct
	public void inicializar() {
		lstCargos = ejbEmpleadoCargos.listarCargos();
		System.out.println(lstCargos.size()+"TAMAÑOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	}

	public DtoEmpleadoNuevo getDtoEmpladoNuevo() {	return dtoEmpladoNuevo;}
	public void setDtoEmpladoNuevo(DtoEmpleadoNuevo dtoEmpladoNuevo) {	this.dtoEmpladoNuevo = dtoEmpladoNuevo;}

	public List<EmpleadoCargo> getLstCargos() {	return lstCargos;}
	public void setLstCargos(List<EmpleadoCargo> lstCargos) {	this.lstCargos = lstCargos;}
	
}
