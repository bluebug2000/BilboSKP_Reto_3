package model;

import java.util.HashMap;

public abstract class Sala {
	private String idSala, nombre, dificultad, tematica, descripcion;
	private int tiempoMax, jugadoresMin, jugadoresMax, edad_recomendada;
	
	private static HashMap<String, Sala> salasCargadas = new HashMap<String, Sala>();
	
	public Sala(String idSala, String nombre, String dificultad, String tematica, String descripcion, int tiempoMax,
			int jugadoresMin, int jugadoresMax, int edad_recomendada) {
		super();
		setIdSala(idSala);
		setNombre(nombre);
		setDificultad(dificultad);
		setTematica(tematica);
		setDescripcion(descripcion);
		setTiempoMax(tiempoMax);
		setJugadoresMin(jugadoresMin);
		setJugadoresMax(jugadoresMax);
		setEdad_recomendada(edad_recomendada);
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	public int getTiempoMax() {
		return tiempoMax;
	}
	public void setTiempoMax(int tiempoMax) {
		this.tiempoMax = tiempoMax;
	}
	public int getJugadoresMin() {
		return jugadoresMin;
	}
	public void setJugadoresMin(int jugadoresMin) {
		this.jugadoresMin = jugadoresMin;
	}
	public int getJugadoresMax() {
		return jugadoresMax;
	}
	public void setJugadoresMax(int jugadoresMax) {
		this.jugadoresMax = jugadoresMax;
	}
	public int getEdad_recomendada() {
		return edad_recomendada;
	}
	public void setEdad_recomendada(int edad_recomendada) {
		this.edad_recomendada = edad_recomendada;
	}
	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIdSala() {
		return this.idSala;
	}
}
