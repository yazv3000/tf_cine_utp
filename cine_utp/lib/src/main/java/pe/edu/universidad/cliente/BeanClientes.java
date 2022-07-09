package pe.edu.universidad.cliente;

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
public class BeanClientes {
	private String cadenaCliente;
	
	private List<DtoClienteConsulta> lstCliente;
	
	@EJB
	private EJBCliente ejbCli;
	
	public BeanClientes() {}
}
