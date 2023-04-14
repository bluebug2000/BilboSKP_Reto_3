package model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Vector;

public class Cupon {
static String id, estado, IdJugador;
static Date fechaCaducidad;

public Cupon(String id, String estado, Date fechaCaducidad) {
	super();
	this.id = id;
	this.estado = estado;
	this.fechaCaducidad = fechaCaducidad;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public Date getFechaCaducidad() {
	return fechaCaducidad;
}

public void setFechaCaducidad(Date fechaCaducidad) {
	this.fechaCaducidad = fechaCaducidad;
}

//Metodo para que el jugador reciba un cupon



public Cupon CambiarEstado(Cupon cupon) {
	//El estado del cupón es activo inicialmente
	cupon.setEstado("ACTIVO");
	LocalDate FechaActual =LocalDate.now();
	LocalDate FechaCaducidad = fechaCaducidad.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	String disponibilidad=cupon.getEstado();
	if(disponibilidad=="ACTIVO") {

		//Si esta activo significa que puede estar caducado
		if(FechaActual.isBefore(FechaCaducidad)) {
			//Si no esta caducado se cambia el estado a EN USO
			cupon.setEstado("EN USO");
			
			//Si no esta caducado se cambia el estado a EN USO
			}else if(FechaActual.isAfter(FechaCaducidad)) {
				cupon.setEstado("CADUCADO");
			}else {
				System.out.println("Caduca hoy");
			}
		
		//Si no esta caducado igual esta en uso
	}else if(disponibilidad=="EN USO"){
		cupon.setEstado("GASTADO");
	}
	
	
	return null;
}
}
