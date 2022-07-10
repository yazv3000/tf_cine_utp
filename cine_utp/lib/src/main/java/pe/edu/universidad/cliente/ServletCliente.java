package pe.edu.universidad.cliente;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.universidad.dto.DtoClienteConsulta;
import pe.edu.universidad.dto.DtoClienteNuevo;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DtoClienteNuevo cliente = new DtoClienteNuevo();
	@EJB
	EJBCliente ejbCliente;
	
    public ServletCliente() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	String accion = request.getParameter("accion");
    	switch (accion) {
		case "listar": {
			List<DtoClienteConsulta> lst = ejbCliente.listarClientes();
			request.setAttribute("lstClientes", lst);
			request.getRequestDispatcher("jsp/Cliente.jsp").forward(request, response);
			break;
		}
		case "Registrar": {
			recuperarDatos(request);
			ejbCliente.registrarCliente(cliente);
			List<DtoClienteConsulta> lst = ejbCliente.listarClientes();
			request.setAttribute("lstClientes", lst);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + accion);
		}
    	
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void recuperarDatos(HttpServletRequest request) {
		cliente.setNomCliePrin(request.getParameter("txtnom1"));
		cliente.setNomClieSec(request.getParameter("txtnom2"));
		cliente.setApeClie(request.getParameter("txtape1")+" "+request.getParameter("txtape2"));
		cliente.setDni(request.getParameter("txtdni"));
		cliente.setCorreo(request.getParameter("txtemail"));
		cliente.setDireccion(request.getParameter("txtdireccion"));

	}
	
}
