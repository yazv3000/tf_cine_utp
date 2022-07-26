package pe.edu.universidad.proc.comprarTicket.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import pe.edu.universidad.proc.comprarTicket.EJBComprarTicket;
import pe.edu.universidad.proc.comprarTicket.dto.DtoTicketConsulta;

@Named						// objeto nombrado
@SessionScoped			// alcance

public class BeanEntrada implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBComprarTicket ejb;		// EJB se inyecta después de crear el objeto bean (después de llamar al constructor)
	
	public BeanEntrada() {
		System.out.println("Creando BeanEntrada");
	}
	
    @PostConstruct
    public void inicializar() {
    	lstTickets = ejb.consultarTicketsTodos();	
    }
	
	// Propiedades : atributo + getter & setter
	private List<DtoTicketConsulta> lstTickets;
	public List<DtoTicketConsulta> getLstTickets() {		return lstTickets;		}
	public void setLstTickets(List<DtoTicketConsulta> lstTickets) {
		this.lstTickets = lstTickets;
	}	

}
