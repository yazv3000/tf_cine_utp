package pe.edu.universidad.proc.comprarProductos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cine_utp_jpa.Cliente;
import cine_utp_jpa.Empleado;
import cine_utp_jpa.Producto;
import cine_utp_jpa.VentaProducto;
import pe.edu.universidad.proc.comprarProductos.dto.DtoClienteConsulta;
import pe.edu.universidad.proc.comprarProductos.dto.DtoProductoConsulta;
import pe.edu.universidad.proc.comprarProductos.dto.DtoVentaConsulta;
import pe.edu.universidad.proc.comprarProductos.dto.DtoVentaNueva;
import pe.edu.universidad.rs.EJBDaoGenerico;


/**
 * Session Bean implementation class EJBComprarProducto
 */
@Path("EJBComprarProducto")
@Stateless
@LocalBean
public class EJBComprarProducto {

	@EJB
	private EJBDaoGenerico dao;
	
	@PersistenceContext(unitName = "cine_utp_jpa")
	private EntityManager em;
    
	/**
     * Default constructor. 
     */
	public EJBComprarProducto() { }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarProductosTodos")
    public List<DtoProductoConsulta> consultarProductosTodos() {
    	
    	Query query = em.createNamedQuery("Producto.findAll");
    	List<Producto> lst = query.getResultList();
    	List<DtoProductoConsulta> lstDto = new ArrayList<DtoProductoConsulta>();
    	
    	for (Producto producto : lst) {
    		lstDto.add(recuperarDtoProducto(producto));
		}
    	
    	return lstDto;
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarClientesTodos")
    public List<DtoClienteConsulta> consultarClientesTodos() {
    	
    	Query query = em.createNamedQuery("Cliente.findAll");
    	List<Cliente> lst = query.getResultList();
    	List<DtoClienteConsulta> lstDto = new ArrayList<DtoClienteConsulta>();
    	
    	for (Cliente cliente : lst) {
    		lstDto.add(recuperarDtoCliente(cliente));
		}

    	return lstDto;
    }

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarVentasTodos")
    public List<DtoVentaConsulta> consultarVentasTodos() {
    	
    	Query query = em.createNamedQuery("VentaProducto.findAll");
    	List<VentaProducto> lst = query.getResultList();
    	List<DtoVentaConsulta> lstDto = new ArrayList<DtoVentaConsulta>();
    	
    	for (VentaProducto venta : lst) {
    		DtoVentaConsulta dtoVenta = new DtoVentaConsulta();
    		dtoVenta.setCodVenta(venta.getCodVenta());
    		dtoVenta.setNombreCliente(venta.getCliente().getNomCl()+" "+venta.getCliente().getApeCl());
    		dtoVenta.setNombreProducto(venta.getProducto().getNombre());
    		dtoVenta.setCantidad(venta.getCantidad());
    		dtoVenta.setFecha(venta.getFechaVenta());
    		dtoVenta.setMonto(venta.getMontoTotal().doubleValue());
    		lstDto.add(dtoVenta);
		}
    	return lstDto;
    }
	
	
    @POST
    @Path("registrarVentaProducto")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public void registrarVentaProducto(DtoVentaNueva v) {
    	
		VentaProducto venta = new VentaProducto();
		venta.setCliente(new Cliente());
		venta.getCliente().setCodCliente(v.getCodCliente());
		venta.setProducto(new Producto());
		venta.getProducto().setCodProducto(v.getCodProducto());
		venta.setEmpleado(new Empleado());
		venta.getEmpleado().setCodEmpleado(v.getCodVendedor());
		venta.setMontoTotal(BigDecimal.valueOf(v.getMonto()));
		venta.setCantidad(v.getCantidad());
		venta.setFechaVenta(v.getFechaVenta());
		em.persist(venta);
	}
    
    public DtoClienteConsulta consultarClientePorId(int idCliente) {
    	Cliente cliente = (Cliente) dao.consultarEntityPorId("Cliente", idCliente);
    	return recuperarDtoCliente(cliente);
    }
    
    public DtoProductoConsulta consultarProductoPorId(int idProducto) {
    	Producto producto = (Producto) dao.consultarEntityPorId("Producto", idProducto);
		return recuperarDtoProducto(producto);
    }
   
    private DtoProductoConsulta recuperarDtoProducto(Producto producto) {
    	DtoProductoConsulta dtoProducto = new DtoProductoConsulta();
    	dtoProducto.setCodProducto(producto.getCodProducto());
    	dtoProducto.setNombre(producto.getNombre());
    	dtoProducto.setPrecio(producto.getPrecio());
    	dtoProducto.setTipo(producto.getTipo());
		return dtoProducto;
    }
    
    private DtoClienteConsulta recuperarDtoCliente(Cliente cliente) {
		DtoClienteConsulta dtoCliente = new DtoClienteConsulta();
		dtoCliente.setCodigo(cliente.getCodCliente());
		dtoCliente.setNombreCompleto(cliente.getNomCl() + " " + cliente.getApeCl());
		dtoCliente.setDni(cliente.getDniCl());
		dtoCliente.setEmail(cliente.getEmailCl());
		return dtoCliente;
    }

}
