package control;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

import connection.DBC;
import model.Sala;
import model.SalaOnline;

public class BilboSKP extends DBC{
	private static final String dbUrl = "localhost:3306/bilboskpdb";
	private static final String user = "bilboskp";
	private static final String pass = "bilboskp";

	public BilboSKP() throws Throwable {
		super(DBC.DRIVER_MYSQL, dbUrl, user, pass);
	}
	
	// conectarse a la BD y obtener todas las salas online
	public static Vector<Sala> getSalasOnline() throws Throwable {
		try {
			// crear el vector que vamos a devolver
			Vector<Sala> vectorSalasOnline = new Vector<Sala>();
			// hacer sentencia sql select todas las salas
			String sentenciaSQL = "select * from salaonline order by idSala;";
			//hacer una conexion
			BilboSKP conexion = new BilboSKP();
			ResultSet resultado = conexion.SQLQuery(sentenciaSQL);
			//hacer un bucle de cada fila que tiene el resultset
			while (resultado.next()) {
				//obtener los campos de cada columna para esta fila
				String idSala = resultado.getString("idSala");
				String nombre = resultado.getString("nombre");
				String dificultad = resultado.getString("dificultad");
				String tematica = resultado.getString("tematica");
				String descripcion = resultado.getString("descripcion");
				int tiempoMax = resultado.getInt("tiempoMax");
				int jugadoresMin = resultado.getInt("jugadoresMin");
				int jugadoresMax = resultado.getInt("jugadoresMax");
				int edadRecomendada = resultado.getInt("edadRecomendada");

				SalaOnline sala = new SalaOnline(idSala, nombre, dificultad, tematica, descripcion, tiempoMax, jugadoresMin, jugadoresMax, edadRecomendada);
				//agregar sala al vector
				vectorSalasOnline.add(sala);
			}
			
			//hacer syso de las salas obtenidas
			System.out.println("Salas obtenidas:");
			if (vectorSalasOnline.size()>0) {
				for (int i=0;i<vectorSalasOnline.size(); i++) {
					Sala SO = vectorSalasOnline.get(i);
					System.out.println(SO.getIdSala()+" > "+SO.getNombre());
				}
			}
			conexion.cerrarFlujo();
			return vectorSalasOnline;
		} catch (Exception e) {
			BilboSKP.sysoError("Error en getSalasOnline");
			e.printStackTrace();
		}
		return null;
	}
	
	// actualizar las salas en una coleccion clave-valor en el hashmap de la clase Sala
	public static boolean cargarSalasOnline() throws Throwable {
		try {
			//limpiar todas las salas cargadas anteriormente
			SalaOnline.clearSalasCargadas();
			
			//obtener las salas de la bd
			Vector<Sala> vectorSalasOnline = BilboSKP.getSalasOnline();
			
			//crear un nuevo hashmap(coleccion clave-valor)
			HashMap<String,Sala> salasPorCargar = new HashMap<String,Sala>();
			
			//si hay un vector de salas 
			if(vectorSalasOnline!= null) {
				//por cada sala la agregamos al hashmap
				for (Sala sala : vectorSalasOnline) {
					//clave: el codigo de sala, valor: la sala
					salasPorCargar.put(sala.getIdSala(), sala);
				}
				//si vectorSalasOnline tiene tamaño 0 quiere decir que no habian salas en el vector
				if(vectorSalasOnline.size()==0) {
					BilboSKP.sysoError("No se encontraron salas que cargar");
				}
				//hacer un set a las salas cargadas
				SalaOnline.setSalasCargadas(salasPorCargar);
				return true;
			}
			
		} catch (Exception e) {
			BilboSKP.sysoError("Error en cargarSalas");
			e.printStackTrace();
		}
		return false;

	}
	
	private static void sysoError(String mensaje) {
		System.out.println("DBC_BilboSKP: "+mensaje);
	}
	
	//TODO METODO 
	ta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/header_footerR.css">
<link rel="stylesheet" href="css/quienes_somosV2.css">
<link rel="stylesheet" href="normalize.css">

<title>BilboSKP</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="icon" type="image/x-icon" href="img/favicon.png">
</head>
<body>
	<%--<%@include file="plantillas/nav.jsp"--%>
	<header>
	<ul>
}
