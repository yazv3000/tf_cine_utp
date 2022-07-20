package pe.edu.universidad.compraProducto;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Path;

import cine_utp_jpa.Producto;
import cine_utp_jpa.VentaProducto;
import pe.edu.universidad.dto.DtoCompraProductoNueva;
import pe.edu.universidad.dto.DtoSi;

/**
 * Session Bean implementation class CompraProducto
 */
@Path("EJBCompraProducto")
@Stateless
@LocalBean
public class EJBCompraProducto {

	@PersistenceContext(unitName = "cine_utp_jpa")
    private EntityManager em;
	
    public EJBCompraProducto() {
        // TODO Auto-generated constructor stub
    }
    /*
     public List<DtoPelicula> consultarPeliculasTodos() {
    	Query query = em.createNamedQuery("Pelicula.findAll");
    	List<Pelicula> lst = query.getResultList();
    	List<DtoPelicula> lstDto = new ArrayList<DtoPelicula>();
    	for (Pelicula pelicula : lst) {
    		DtoPelicula dto = new DtoPelicula();
    		dto.setId(pelicula.getCodPelicula());
    		dto.setNombre(pelicula.getNomPeli());
    		lstDto.add(dto);
		}
    	
    	return lstDto;
    }
     */
    public List<DtoSi> consultarProductosUnitarios(){
    	Query query = em.createNamedQuery("Producto.unitarios");
    	List<Producto> lst = query.getResultList();
    	List<DtoSi> lstDto = new ArrayList<DtoSi>();
    	for (Producto producto : lst) {
    		DtoSi dto = new DtoSi();
			dto.setId(producto.getCodProducto());
			dto.setNombre(producto.getNombre());
			lstDto.add(dto);
			System.out.println(producto.getNombre()+" ````nombre we");
			
    	}
    	System.out.println("estoy entrando al metodo listar");
    	return lstDto;
    }
    public List<DtoSi> consultarProductosCombos(){
    	Query query = em.createNamedQuery("Producto.combos");
    	List<Producto> lst = query.getResultList();
    	List<DtoSi> lstDto = new ArrayList<DtoSi>();
    	for (Producto producto : lst) {
    		DtoSi dto = new DtoSi();
			dto.setId(producto.getCodProducto());
			dto.setNombre(producto.getNombre());
			lstDto.add(dto);
    	}
    	return lstDto;
    }
    public int consultarPrecioProducto(int idProducto) {
    	int cost = 0;
    	Query query = em.createNamedQuery("Producto.precio");
    	query.setParameter("number", idProducto);
    	cost=(int) query.getSingleResult();
    	System.out.println(cost);
    	return cost;
    }
    public void registrarCompra(DtoCompraProductoNueva dtoCompraProductoNueva) {
    	VentaProducto ventaProducto = new VentaProducto();
    	ventaProducto.setCodCliente(10);
    	ventaProducto.setCodVendedor(10);
    	ventaProducto.setCodProducto(dtoCompraProductoNueva.getCodProducto());
    	ventaProducto.setFechaVenta(new Date());
    	double preciototal = consultarPrecioProducto(dtoCompraProductoNueva.getCodProducto())*dtoCompraProductoNueva.getCantidad();
    	dtoCompraProductoNueva.setFechaVenta(new Date());
    	dtoCompraProductoNueva.setMontoTotal(preciototal);
    	ventaProducto.setMontoTotal(BigDecimal.valueOf(preciototal));
    	ventaProducto.setCantidad(dtoCompraProductoNueva.getCantidad());
    	em.persist(ventaProducto);    	
    }
}
