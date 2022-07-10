package pe.edu.universidad.cliente;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.dto.DtoClienteConsulta;


@Named
@SessionScoped
public class BeanClientes implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//ENTIDADES
	private String cadenaCliente;
	
	//LISTAS
	private List<DtoClienteConsulta> lst;
	
	@EJB
	private EJBCliente ejb;
	
	@PostConstruct
	public  void inicializar() {
		lst = ejb.listarClientes();
	}
	
	public BeanClientes() {}
}
