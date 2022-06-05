package pe.edu.universidad.registrarBoleta;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.universidad.dto.DtoClienteConsulta;

/**
 * Servlet implementation class ServletRegistroBoleta
 */
@WebServlet("/ServletRegistroBoleta")
public class ServletRegistroBoleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    EJBRegistroBoleta ejb;
	
    
    public ServletRegistroBoleta() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");

		switch (accion.toLowerCase()) {
			case "buscar":
				String busqueda = request.getParameter("cadena");
				List<DtoClienteConsulta> lst = ejb.consultarClientes(busqueda);
				request.getSession().setAttribute("lstDtoClientes", lst);
				request.getRequestDispatcher("ventaEntradas/seleccionCliente.jsp").forward(request, response);
			break;
			
			case "seleccionar":
				DtoClienteConsulta clienteDto = new DtoClienteConsulta();
				System.out.println("hasta aqui oki");
				clienteDto = (DtoClienteConsulta) request.getAttribute("cliente");
				
			break;
			
		default:
			break;
		}
		

		
	}

}
