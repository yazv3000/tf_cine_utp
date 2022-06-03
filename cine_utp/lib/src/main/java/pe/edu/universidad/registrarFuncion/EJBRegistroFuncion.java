package pe.edu.universidad.registrarFuncion;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.universidad.cine_utp_jpa.entidades.*;
import pe.edu.universidad.dto.DtoPelicula;


/**
 * Session Bean implementation class EJBRegistroFuncion
 */
@Stateless
@LocalBean
public class EJBRegistroFuncion {

    @PersistenceContext(unitName = "cine_utp_jpa")
    private EntityManager em;

    public EJBRegistroFuncion() {
        
    }
    
    public List<DtoPelicula> consultarPeliculas() {
    	System.out.println("  Ingreso ******************************************ingreso");
    	Query query = em.createNamedQuery("Pelicula.findAll");
    	List<DtoPelicula> dtoList = new ArrayList<DtoPelicula>();
    	List<Pelicula> lst = query.getResultList();
    	for (Pelicula pelicula : lst) {
    		DtoPelicula dto = new DtoPelicula();
    		dto.setNom_peli(pelicula.getNomPeli());
    		dto.setCod_pelicula(pelicula.getCodPelicula());
    		System.out.println(pelicula.getNomPeli() + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    		dtoList.add(dto);
		}
    	
    	return dtoList;
    }
    
//    public List<DtoCurso> consultarCursosTodos() {
//    	Query query = em.createNamedQuery("Curso.findAll");
//    	List<Curso> lst = query.getResultList();
//    	List<DtoCurso> lstDto = new ArrayList<DtoCurso>();
//    	for (Curso curso : lst) {
//			DtoCurso dto = new DtoCurso();
//			dto.setId(curso.getId());
//			dto.setNombre(curso.getNombre());
//			dto.setCantidadHoras(curso.getHorasLab()+curso.getHorasPractica()+curso.getHorasTeoria());
//			lstDto.add(dto);
//		}
//    	return lstDto;
//    }

}
