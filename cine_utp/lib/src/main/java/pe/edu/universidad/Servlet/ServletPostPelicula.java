package pe.edu.universidad.Servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.universidad.dto.DtoPelicula;
import pe.edu.universidad.registrarFuncion.EJBRegistroFuncion;


@WebServlet("/ServletPostPelicula")
public class ServletPostPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    EJBRegistroFuncion ejbPelicula;
	
    public ServletPostPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DtoPelicula> lst = ejbPelicula.consultarPeliculas();
		System.out.println("<<<<<<<<<<<<<<<*******//////*****<<<<<<<<<<<<<<<<<<");
		System.out.println(lst.size() + "/////*******//*");
		request.getSession().setAttribute("lst", lst);
		request.getRequestDispatcher("jsp/prueba.jsp").forward(request, response);
	}

}
