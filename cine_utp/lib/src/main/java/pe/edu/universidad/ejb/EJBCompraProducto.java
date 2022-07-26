package pe.edu.universidad.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cine_utp_jpa.Producto;
import pe.edu.universidad.dto.DtoProductoConsulta;

/**
 * Session Bean implementation class EJBCompraProducto
 */
@Stateless
@LocalBean
public class EJBCompraProducto {

	@PersistenceContext(unitName = "cine_utp_jpa")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public EJBCompraProducto() {

    }

    public List<DtoProductoConsulta> consultarProductosTodos() {
    	
    	Query query = em.createNamedQuery("Producto.findAll");
    	List<Producto> lst = query.getResultList();
    	List<DtoProductoConsulta> lstDto = new ArrayList<DtoProductoConsulta>();
    	
    	for (Producto producto : lst) {
    		lstDto.add(recuperarDtoProducto(producto));
		}
    	
    	return lstDto;
    }
    
    private DtoProductoConsulta recuperarDtoProducto(Producto producto) {
    	DtoProductoConsulta dtoProducto = new DtoProductoConsulta();
    	dtoProducto.setCodProducto(producto.getCodProducto());
    	dtoProducto.setNombre(producto.getNombre());
    	dtoProducto.setPrecio(producto.getPrecio());
    	dtoProducto.setTipo(producto.getTipo());
		return dtoProducto;
    }
    
    public List<DtoProductoConsulta> agregarProductoCarrito(List<DtoProductoConsulta> carrito,DtoProductoConsulta p){
    	if(carrito == null)
    		carrito= new ArrayList<DtoProductoConsulta>();
    	carrito.add(p);
    	return carrito;
    }
    
    public List<DtoProductoConsulta> elimiarProductoCarrito(List<DtoProductoConsulta> carrito, int codProducto){
    	if (carrito == null)
			return null;
		int i=0;
		for (DtoProductoConsulta p : carrito) {
			if (p.getCodProducto() == codProducto) {
				carrito.remove(i);
				break;
			}	
			i++;
		}
		return carrito;
    }
    
    public double calcularTotalCarrito(List<DtoProductoConsulta> carrito) {
    	double total = 0;
    	for (DtoProductoConsulta p : carrito) {
			total+=p.getPrecio();
		}
    	return total;
    }
}
