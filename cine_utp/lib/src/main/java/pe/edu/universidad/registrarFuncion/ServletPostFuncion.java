package pe.edu.universidad.registrarFuncion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cine_utp_jpa.Pelicula;
import pe.edu.universidad.dto.DtoFuncionNueva;
import pe.edu.universidad.dto.DtoPeli;
import pe.edu.universidad.entidades.sala;

/**
 * Servlet implementation class ServletPostFuncion
 */
@WebServlet("/ServletPostFuncion")
public class ServletPostFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	EJBFuncion ejb;
	
	DtoPeli dto = new DtoPeli();
	
    public ServletPostFuncion() {
        super();
    }

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");

		switch (accion) {
		case "buscar":
			String nombrePelicula = request.getParameter("nom_peli");
			List<DtoPeli> lst = ejb.consultarPeliculaId(nombrePelicula);
			request.getSession().setAttribute("lstPeliculas", lst);
			request.getRequestDispatcher("registrarFuncion/seleccionPelicula.jsp").forward(request, response);
			break;
			
		case "seleccionar":
			int codPeli = Integer.parseInt(request.getParameter("codPeli"));
			String nombre = request.getParameter("nombre");
			int duracion = Integer.parseInt(request.getParameter("duracion"));
			

			dto.setCodigo(codPeli);
			dto.setNombre(nombre);
			dto.setDuracion(duracion);
			request.getSession().setAttribute("peliculaDto", dto);
			listarSalas(request);
			request.getRequestDispatcher("registrarFuncion/registroFuncion.jsp").forward(request, response);
			break;

		case "confirmar":
			
			 dto = (DtoPeli) request.getSession().getAttribute("peliculaDto");
			 Pelicula objpeli = new Pelicula();
			 objpeli.setCodPelicula(dto.getCodigo());
			 
			 int codSala = Integer.parseInt(request.getParameter("sala"));
			 String hora = request.getParameter("hora");
			 System.out.println("Agregando .................."+hora+"esa es la hora");
			 String fecha =  request.getParameter("fecha");
			 double precio = Double.parseDouble(request.getParameter("precio"));
			 
			 DtoFuncionNueva f = new DtoFuncionNueva();
			 
			 f.setCodSala(codSala);
			 f.setHoraInicio(hora);
			 f.setFecha(fecha);
			 f.setPeli(objpeli);
			 f.setPrecio(precio);
			 ejb.insertarFuncion(f);
			 break;
		}
		

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entra al get");
		processRequest(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entra al post");
		processRequest(request, response);
	}
	
	private void listarSalas(HttpServletRequest request) {
		//Salas
		List<sala> salas = ejb.consultarSalas();
		request.getSession().setAttribute("lstSalas", salas);
		System.out.println("listando salas ...");
	}
	
}
