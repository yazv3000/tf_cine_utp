package pe.edu.universidad.proc.alquilarSala.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import cine_utp_jpa.HorarioSala;
import cine_utp_jpa.Reserva;
import cine_utp_jpa.Sala;
import pe.edu.universidad.proc.alquilarSala.EJBAlquilarSala;

@Named
@SessionScoped
public class BeanHorariosReserva implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBAlquilarSala ejb;

	@Inject
	private BeanAlquilerSala beanAlquilerSala;


	public BeanHorariosReserva() {
		fechaDisponible = new Date();
	}

	@PostConstruct
	public void inicializar() {
		filtrarHorario();
	}

	public void filtrarHorario() {
		List<HorarioSala> horario = ejb.listadoDeHorariosPorFecha(fechaDisponible);
		itemsHorarios = new ArrayList<SelectItem>();
		
		for (HorarioSala horarioSala : horario) {
			
			if (horarioSala.getSala().getCodSala() ==  beanAlquilerSala.getCodSala()) {
				SelectItem si = new SelectItem();
				si.setLabel(horarioSala.getHora().getHours()<10?"0"+horarioSala.getHora().getHours()+":00":horarioSala.getHora().getHours()+":00");
				si.setValue(horarioSala.getCodigo());
				
				itemsHorarios.add(si);
			}
		}
	}

	public String insertarReserva() {
		beanAlquilerSala.getReserva().setCodHorario(idHorarioSeleccionado);
		HorarioSala h = ejb.consultarHorarioPorId(idHorarioSeleccionado);
		System.out.println(h.getCodigo());
		System.out.println(h.getHora());
		beanAlquilerSala.setHorario(h);
		System.out.println("El código del horario: "+idHorarioSeleccionado);
		
		beanAlquilerSala.setReserva(beanAlquilerSala.getReserva());
		ejb.reservaDeSala(beanAlquilerSala.getReserva());
		return "resumenReserva";
	}

	public String actualizarPagina() {
		filtrarHorario();
		return "horariosSala";
	}
	
	// Propiedades
	private List<SelectItem> itemsHorarios;
	public List<SelectItem> getItemsHorarios() {		return itemsHorarios;	}
	public void setItemsHorarios(List<SelectItem> itemsHorarios) {		this.itemsHorarios = itemsHorarios;	}

	private Date fechaDisponible;
	public Date getFechaDisponible() {
		return fechaDisponible;
	}
	public void setFechaDisponible(Date fechaDisponible) {
		this.fechaDisponible = fechaDisponible;
	}

	private int idHorarioSeleccionado;
	public int getIdHorarioSeleccionado() {
		return idHorarioSeleccionado;
	}
	public void setIdHorarioSeleccionado(int idHorarioSeleccionado) {
		this.idHorarioSeleccionado = idHorarioSeleccionado;
	}

}