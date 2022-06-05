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
import pe.edu.universidad.dto.DtoFuncionConsulta;
import pe.edu.universidad.dto.DtoNuevoTicket;

/**
 * Servlet implementation class ServletRegistroBoleta
 */
@WebServlet("/ServletRegistroBoleta")
public class ServletRegistroBoleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    EJBRegistroBoleta ejb;
	
	static DtoClienteConsulta clienteDto = new DtoClienteConsulta();
	static DtoFuncionConsulta funcionDto = new DtoFuncionConsulta();
    
    public ServletRegistroBoleta() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String accion = request.getParameter("accion");
		System.out.println(accion);
		switch (accion) {
			case "buscar_cliente":
				String busqueda = request.getParameter("cadena");
				List<DtoClienteConsulta> lst = ejb.consultarClientes(busqueda);
				request.getSession().setAttribute("lstDtoClientes", lst);
				request.getRequestDispatcher("ventaEntradas/seleccionCliente.jsp").forward(request, response);
			break;
			
			case "seleccionar_cliente":
				clienteDto = (DtoClienteConsulta) request.getAttribute("cliente");
				System.out.println("cliente es:" + request.getAttribute("cliente"));
				request.getSession().setAttribute("cliente_entrada", clienteDto);
				request.getRequestDispatcher("ventaEntradas/seleccionFuncion.jsp").forward(request, response);
			break;
			
			case "buscar_funcion":
				int cod = Integer.parseInt(request.getParameter("codigo"));
				List<DtoFuncionConsulta> lst2 = ejb.consultarFunciones(cod);
				request.getSession().setAttribute("lstDtoFunciones", lst2);
				request.getRequestDispatcher("ventaEntradas/seleccionFuncion.jsp").forward(request, response);
			break;
			
			
			case "seleccionar_funcion":
				funcionDto = (DtoFuncionConsulta) request.getAttribute("funcion");
				System.out.println("funcion es:" + request.getAttribute("funcion"));
				request.getSession().setAttribute("funcion_entrada",funcionDto);
				request.getRequestDispatcher("ventaEntradas/registroEntrada.jsp").forward(request, response);
			break;
			
			case "confirmar":
				DtoNuevoTicket ticket = new DtoNuevoTicket();
				clienteDto = (DtoClienteConsulta) request.getSession().getAttribute("cliente_entrada");
				funcionDto = (DtoFuncionConsulta) request.getSession().getAttribute("funcion_entrada");
				
				ticket.setCodCliente(305);
				ticket.setCodFuncion(400);
				
//				ticket.setCodCliente(clienteDto.getIdCliente());
//				ticket.setCodFuncion(funcionDto.getCodFuncion());
				ejb.insertarTicket(ticket);
	
			break;
		default:
			System.out.println("default");
			break;
		}

	}
}
