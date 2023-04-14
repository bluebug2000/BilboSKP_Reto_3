package model;

import java.util.Date;

public class Partida {
	private int idPartida, idAnfitrion, puntos, numJugadores;
	

	private String idSala, nombreGrupo,idReserva;
	Date fechaInicio, fechaFin;
	
	public Partida(int idPartida, int idAnfitrion, String idReserva, int puntos, int numJugadores, String idSala,
			String nombreGrupo, Date fechaInicio, Date fechaFin) {
		super();
		this.idPartida = idPartida;
		this.idAnfitrion = idAnfitrion;
		this.idReserva= idReserva;
		this.puntos = puntos;
		this.numJugadores = numJugadores;
		this.idSala = idSala;
		this.nombreGrupo = nombreGrupo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	
	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public int getIdAnfitrion() {
		return idAnfitrion;
	}

	public void setIdAnfitrion(int idAnfitrion) {
		this.idAnfitrion = idAnfitrion;
	}

	public String getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getNumJugadores() {
		return numJugadores;
	}

	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}

	public String getIdSala() {
		return idSala;
	}

	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
