package model;

import java.util.Date;
import java.util.Vector;

public class Reserva {
	//atributos 
	private String idReserva , idSalaFisica;
	private int idSuscriptor, numJugadores;
	private Date fechaHora;
	
	
	public Reserva(String idReserva, String idSalaFisica, int idSuscriptor, int numJugadores, Date fechaHora) {
		super();
		this.idReserva = idReserva;
		this.idSalaFisica = idSalaFisica;
		this.idSuscriptor = idSuscriptor;
		this.numJugadores = numJugadores;
		this.fechaHora = fechaHora;
	}
	
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public String getIdSalaFisica() {
		return idSalaFisica;
	}
	public void setIdSalaFisica(String idSalaFisica) {
		this.idSalaFisica = idSalaFisica;
	}
	public int getIdSuscriptor() {
		return idSuscriptor;
	}
	public void setIdSuscriptor(int idSuscriptor) {
		this.idSuscriptor = idSuscriptor;
	}
	public int getNumJugadores() {
		return numJugadores;
	}
	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}


	//metodos 
    //obtener las reservas de un suscriptor de la bd
	public static Vector <Reserva> obtenerReserva() throws Throwable {
		Vector <Reserva> reservas= new Vector<Reserva>();
		String sentenciaSQL="SELECT * FROM reserva WHERE idSuscriptor is not null";
		
		
		
		
		return reservas;
	
		
	}
	//hacer una nueva reserva de una sala física 
	public void crearReserva () {
		
	}
	//cancelar una reserva dado su id 
	public void cancelarReserva () {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
