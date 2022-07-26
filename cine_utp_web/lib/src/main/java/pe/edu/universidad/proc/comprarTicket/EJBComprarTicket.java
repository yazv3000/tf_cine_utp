package pe.edu.universidad.proc.comprarTicket;

import java.util.ArrayList;
import java.util.Arrays;
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
import cine_utp_jpa.Entrada;
import cine_utp_jpa.Funcion;
import cine_utp_jpa.Sala;
import pe.edu.universidad.proc.comprarTicket.dto.DtoAsiento;
import pe.edu.universidad.proc.comprarTicket.dto.DtoClienteConsulta;
import pe.edu.universidad.proc.comprarTicket.dto.DtoFuncionConsulta;
import pe.edu.universidad.proc.comprarTicket.dto.DtoTicketConsulta;
import pe.edu.universidad.proc.comprarTicket.dto.DtoTicketNuevo;
import pe.edu.universidad.rs.EJBDaoGenerico;


/**
 * Session Bean implementation class EJBComprarTicket
 */
@Path("EJBComprarTicket")
@Stateless
@LocalBean
public class EJBComprarTicket {

	@EJB
	private EJBDaoGenerico dao;
	
	@PersistenceContext(unitName = "cine_utp_jpa")
	private EntityManager em;
    
	/**
     * Default constructor. 
     */
	public EJBComprarTicket() { }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarFuncionesTodos")
    public List<DtoFuncionConsulta> consultarFuncionesTodos() {
    	
    	Query query = em.createNamedQuery("Funcion.findAll");
    	List<Funcion> lst = query.getResultList();
    	List<DtoFuncionConsulta> lstDto = new ArrayList<DtoFuncionConsulta>();
    	
    	for (Funcion funcion : lst) {
    		lstDto.add(recuperarDtoFuncion(funcion));
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
    @Path("consultarTicketsTodos")
    public List<DtoTicketConsulta> consultarTicketsTodos() {
    	
    	Query query = em.createNamedQuery("Entrada.findAll");
    	List<Entrada> lst = query.getResultList();
    	List<DtoTicketConsulta> lstDto = new ArrayList<DtoTicketConsulta>();
    	
    	for (Entrada entrada : lst) {
    		DtoTicketConsulta dtoTicket = new DtoTicketConsulta();
    		dtoTicket.setCodTicket(entrada.getCodTicket());
    		dtoTicket.setCodFuncion(entrada.getFuncion().getCodFuncion());
    		dtoTicket.setNombrePelicula(entrada.getFuncion().getPelicula().getNomPeli());
    		dtoTicket.setNombreCliente(entrada.getCliente().getNomCl()+" "+entrada.getCliente().getApeCl());
    		dtoTicket.setSala("Sala "+entrada.getFuncion().getCodSala());
    		dtoTicket.setAsiento(entrada.getAsiento());
    		dtoTicket.setFechaFuncion(entrada.getFuncion().getFechaFuncion());
    		dtoTicket.setFechaCompra(entrada.getFechaCompra());
    		lstDto.add(dtoTicket);
		}
    	return lstDto;
    }
	
	
    @POST
    @Path("registrarTicket")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public void registrarTicket(DtoTicketNuevo t) {
		Entrada entrada = new Entrada();
		entrada.setFuncion(new Funcion());
		entrada.getFuncion().setCodFuncion(t.getCodFuncion());
		entrada.setCliente(new Cliente());
		entrada.getCliente().setCodCliente(t.getCodCliente());
		entrada.setCodCajero(t.getCodCajero());
		entrada.setAsiento(t.getAsiento());
		entrada.setFechaCompra(t.getFechaCompra());
		em.persist(entrada);
	}
    
    public DtoClienteConsulta consultarClientePorId(int idCliente) {
    	Cliente cliente = (Cliente) dao.consultarEntityPorId("Cliente", idCliente);
    	return recuperarDtoCliente(cliente);
    }
    
    public DtoFuncionConsulta consultarFuncionPorId(int idFuncion) {
    	Funcion funcion = (Funcion) dao.consultarEntityPorId("Funcion", idFuncion);
		return recuperarDtoFuncion(funcion);
    }
    
    private DtoFuncionConsulta recuperarDtoFuncion(Funcion funcion) {
    	DtoFuncionConsulta dtoFuncion = new DtoFuncionConsulta();
		dtoFuncion.setCodFuncion(funcion.getCodFuncion());
		dtoFuncion.setNombrePelicula(funcion.getPelicula().getNomPeli());
		dtoFuncion.setSala("Sala "+funcion.getCodSala());
		dtoFuncion.setFecha(funcion.getFechaFuncion());
		dtoFuncion.setHora(funcion.getHoraInicio());
		System.out.println(funcion.getPrecio().doubleValue());
		dtoFuncion.setPrecio(funcion.getPrecio().doubleValue());
		return dtoFuncion;
    }
    
    private DtoClienteConsulta recuperarDtoCliente(Cliente cliente) {
		DtoClienteConsulta dtoCliente = new DtoClienteConsulta();
		dtoCliente.setCodigo(cliente.getCodCliente());
		dtoCliente.setNombreCompleto(cliente.getNomCl() + " " + cliente.getApeCl());
		dtoCliente.setDni(cliente.getDniCl());
		dtoCliente.setEmail(cliente.getEmailCl());
		return dtoCliente;
    }

	public List<DtoAsiento> consultarAsientosPorFuncion(int idFuncion) {
		int idSala = ((Funcion) dao.consultarEntityPorId("Funcion", idFuncion)).getCodSala();
		int capacidadSala = ((Sala) dao.consultarEntityPorId("Sala", idSala)).getCapacidad();
		System.out.println("capacidad de sala:"+capacidadSala);
		DtoAsiento[] asientos = new DtoAsiento[capacidadSala];
		
		Query query = em.createNamedQuery("Entrada.findAsientosOcupados");
		query.setParameter("number", idFuncion);
    	List<Integer> lst = query.getResultList();

    	List<DtoAsiento> lstDto = new ArrayList<DtoAsiento>();
    	for (int i=0; i<capacidadSala; i++) {
    		asientos[i] = new DtoAsiento((i+1));
		}
    	for (Integer ocupado : lst) {
    		asientos[ocupado-1].setEstadoDisponible(false);
    		System.out.println(ocupado);
		}
    	return Arrays.asList(asientos);
	}
}
