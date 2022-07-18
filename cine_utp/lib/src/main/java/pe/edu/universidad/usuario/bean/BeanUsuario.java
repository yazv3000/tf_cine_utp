package pe.edu.universidad.usuario.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import pe.edu.universidad.cliente.EJBCliente;
import pe.edu.universidad.dto.DtoClienteConsulta;

@Named
@SessionScoped
public class BeanUsuario implements Serializable {
	private List<DtoClienteConsulta> lstCliente;
	@EJB
	private EJBCliente ejb;
	
	public BeanUsuario() {
		lstCliente = ejb.listarClientes();
	}
	
	@PostConstruct
	public void listar() {
//		lstCliente = ejb.listarClientes();
	}
	
}
