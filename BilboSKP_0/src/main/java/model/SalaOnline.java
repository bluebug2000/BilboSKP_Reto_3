package model;

import java.util.HashMap;

public class SalaOnline extends Sala{
	//este hashmap contendrá todas las salas online disponibles
	private static HashMap<String, Sala> salasOnlineCargadas = new HashMap<String, Sala>();

	public SalaOnline(String idSala, String nombre, String dificultad, String tematica, String descripcion,
			int tiempoMax, int jugadoresMin, int jugadoresMax, int edadRecomendada) {
		super(idSala, nombre, dificultad, tematica, descripcion, tiempoMax, jugadoresMin, jugadoresMax, edadRecomendada);
		// TODO Auto-generated constructor stub
	}

	public static void setSalasCargadas(HashMap<String, Sala> salasCargadas) {
		salasOnlineCargadas = salasCargadas;
	}
	public static HashMap<String, Sala> getSalasCargadas() {
		return salasOnlineCargadas;
	}
	public static void clearSalasCargadas() {
		salasOnlineCargadas.clear();
	}
}
