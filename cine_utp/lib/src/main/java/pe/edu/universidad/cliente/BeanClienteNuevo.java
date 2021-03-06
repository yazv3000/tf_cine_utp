package pe.edu.universidad.cliente;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.dto.DtoClienteConsulta;
import pe.edu.universidad.dto.DtoClienteNuevo;

@Named
@SessionScoped
public class BeanClienteNuevo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//ENTIDADES
	private DtoClienteNuevo dtoClienteNuevo;
	
	@Inject
	private BeanClientes beanClientes;
	
	@EJB
	private EJBCliente ejb;
	public BeanClienteNuevo () {
		dtoClienteNuevo = new DtoClienteNuevo();
	}
	
	@PostConstruct
	public void inicializar() {
//		List<Usuario> ususario = new ArrayList<Usuario>();
		
	}
	public void guardarCliente() {
		ejb.registrarCliente(dtoClienteNuevo);
//		beanClientes.inicializar();
	}

	public DtoClienteNuevo getDtoClienteNuevo() {	return dtoClienteNuevo;}
	public void setDtoClienteNuevo(DtoClienteNuevo dtoClienteNuevo) {	this.dtoClienteNuevo = dtoClienteNuevo;}
	
}
