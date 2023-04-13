package model;

import java.util.Date;

public class Horario {
	private String idSalaFisica;
	
	
	private Date fechaHora;
	private boolean disponible;
public Horario(String idSalaFisica, Date fechaHora, boolean disponible) {
		super();
		this.idSalaFisica = idSalaFisica;
		this.fechaHora = fechaHora;
		this.disponible = disponible;
	}

public String getIdSalaFisica() {
		return idSalaFisica;
	}
	public void setIdSalaFisica(String idSalaFisica) {
		this.idSalaFisica = idSalaFisica;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}




}
