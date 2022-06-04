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
 * Servlet implementation class ServletPostFuncionn
 */
@WebServlet("/ServletPostFuncionn")
public class ServletPostFuncionn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	EJBFuncion ejb;
    public ServletPostFuncionn() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");

		switch (accion) {
		case "buscar":
			String nombrePelicula = request.getParameter("nom_peli");
			List<DtoPeli> lst = ejb.consultarPeliculaId(nombrePelicula);
			request.getSession().setAttribute("lstPeliculas", lst);
			request.getRequestDispatcher("jsp/RegistrarFuncion.jsp").forward(request, response);
			break;
			
		case "agregar":
			int codPeli = Integer.parseInt(request.getParameter("codPeli"));
			String nombre = request.getParameter("nombre");
			int duracion = Integer.parseInt(request.getParameter("duracion"));
			
			List<DtoPeli> dtoPelis = (List<DtoPeli>) request.getSession().getAttribute("lstPeliculaFuncion");
			if (dtoPelis == null) {
				dtoPelis = new ArrayList<DtoPeli>();
			}

			DtoPeli dto = new DtoPeli();
			dto.setCodigo(codPeli);
			dto.setNombre(nombre);
			dto.setDuracion(duracion);
			dtoPelis.add(dto);
			
			//Salas
			List<sala> salas = ejb.consultarSalas();
			request.getSession().setAttribute("lstSalas", salas);
			request.getSession().setAttribute("lstPeliculaFuncion", dtoPelis);
			request.getRequestDispatcher("jsp/RegistrarFuncion.jsp").forward(request, response);
			
			break;
//		case "quitar":
//			int codPelicula = Integer.parseInt(request.getParameter("codPeli"));
//			List<DtoPeli> dtoLst = (List<DtoPeli>) request.getSession().getAttribute("lstPeliculaFuncion");
//			for (DtoPeli dtoPeli : dtoLst) {
//				if (dtoPeli.getCodigo() == codPelicula) {
//					dtoLst.remove(dtoPeli);
//					break;
//				}
//			}
//			request.getRequestDispatcher("RegistrarFuncion.jsp").forward(request, response);
//			break;
		case "confirmar":
			 codPeli = Integer.parseInt(request.getParameter("codPeli"));
			 Pelicula objpeli = new Pelicula();
			 objpeli.setCodPelicula(codPeli);
			 
			 int codSala = Integer.parseInt(request.getParameter("sala"));
			 String hora = request.getParameter("hora");
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
		processRequest(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
