package pe.edu.universidad.registrarBoleta;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.universidad.cliente.EJBCliente;
import pe.edu.universidad.dto.DtoClienteConsulta;

/**
 * Servlet implementation class ServletGetCliente
 */
@WebServlet("/ServletGetCliente")
public class ServletGetCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    EJBRegistroBoleta ejb;
	
    
    public ServletGetCliente() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda = request.getParameter("cadena");
		List<DtoClienteConsulta> lst = ejb.consultarClientes(busqueda);
		request.getSession().setAttribute("lstClientes", lst);
		request.getRequestDispatcher("ventatickets/nuevaBoleta.jsp").forward(request, response);
		
	}

}
