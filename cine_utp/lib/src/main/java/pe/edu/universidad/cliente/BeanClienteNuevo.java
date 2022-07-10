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
	
	//ENTIDADES
	private DtoClienteNuevo dtoClienteNuevo;
	
	//LISTAS
	private List<DtoClienteConsulta> lst;
	
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
	public String guardarCliente() {
		ejb.registrarCliente(dtoClienteNuevo);
		beanClientes.inicializar();
		return "cursos";
	}
	
	public DtoClienteNuevo getDtoNuevo() {
		return dtoClienteNuevo;
	}
	
	public void setDtoNuevo(DtoClienteNuevo dtoNuevo) {
		this.dtoClienteNuevo = dtoNuevo;
	}
	
	
}
