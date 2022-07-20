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
	
	private static final long serialVersionUID = 1L;

	//ENTIDADES
	private DtoEmpleadoNuevo dtoEmpleadoNuevo;
	
	//LISTAS
	private List<EmpleadoCargo> lstCargos;
	@EJB
	private EJB_EmpleadoCargo ejbEmpleadoCargos;
	@EJB
	private EJB_Empleado ejbEmpleado;
	
	
	public BeanEmpleadoNuevo() {
		dtoEmpleadoNuevo = new DtoEmpleadoNuevo();
	}
	
	@PostConstruct
	public void inicializar() {
		lstCargos = ejbEmpleadoCargos.listarCargos();
	}
	
	public void guardarEmpleado() {
		ejbEmpleado.registrarEmpleado(dtoEmpleadoNuevo);
		
	}
	
	public DtoEmpleadoNuevo getDtoEmpleadoNuevo() {	return dtoEmpleadoNuevo;}
	public void setDtoEmpleadoNuevo(DtoEmpleadoNuevo dtoEmpleadoNuevo) {	this.dtoEmpleadoNuevo = dtoEmpleadoNuevo;}

	public List<EmpleadoCargo> getLstCargos() {	return lstCargos;}
	public void setLstCargos(List<EmpleadoCargo> lstCargos) {	this.lstCargos = lstCargos;}
	
}
