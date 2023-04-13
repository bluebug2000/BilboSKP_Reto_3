package control;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Vector;
import java.text.SimpleDateFormat;

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
	// conectarse a la BD y obtener todas las salas fisicas
		public static Vector<Sala> getSalasFisicas() throws Throwable {
			try {
				// crear el vector que vamos a devolver
				Vector<Sala> vectorSalasFisicas = new Vector<Sala>();
				// hacer sentencia sql select todas las salas
				String sentenciaSQL = "select * from salafisica order by idSala;";
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
					int edad_recomendada = resultado.getInt("edad_recomendada");
					String direccion = resultado.getString("direccion");
					int telefono = resultado.getInt("telefono");

					SalaFisica sala = new SalaFisica(idSala, nombre, dificultad, tematica, descripcion, tiempoMax, jugadoresMin, jugadoresMax, edad_recomendada, direccion, telefono);
					//agregar sala al vector
					vectorSalasFisicas.add(sala);
				}
				
				//hacer syso de las salas obtenidas
				System.out.println("Salas obtenidas:");
				if (vectorSalasFisicas.size()>0) {
					for (int i=0;i<vectorSalasFisicas.size(); i++) {
						Sala SO = vectorSalasFisicas.get(i);
						System.out.println(SO.getIdSala()+" > "+SO.getNombre());
					}
				}
				conexion.cerrarFlujo();
				return vectorSalasFisicas;
			} catch (Exception e) {
				BilboSKP.sysoError("Error en getSalasFisicas");
				e.printStackTrace();
			}
			return null;
		}
		// actualizar las salas en una coleccion clave-valor en el hashmap de la clase Sala
		public static boolean cargarSalasFisicas() throws Throwable {
			try {
				//limpiar todas las salas cargadas anteriormente
				SalaFisica.clearSalasCargadas();
				
				//obtener las salas de la bd
				Vector<Sala> vectorSalasFisicas = BilboSKP.getSalasFisicas();
				
				//crear un nuevo hashmap(coleccion clave-valor)
				HashMap<String,Sala> salasPorCargar = new HashMap<String,Sala>();
				
				//si hay un vector de salas 
				if(vectorSalasFisicas!= null) {
					//por cada sala la agregamos al hashmap
					for (Sala sala : vectorSalasFisicas) {
						//clave: el codigo de sala, valor: la sala
						salasPorCargar.put(sala.getIdSala(), sala);
					}
					//si vectorSalasFisicas tiene tamaÃ±o 0 quiere decir que no habian salas en el vector
					if(vectorSalasFisicas.size()==0) {
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
	// conectarse a la BD y obtener todos los horarios de la sala fisica que introduzcas
		public static Vector<Horario> obtenerFechasFisica(String idSala) throws Throwable {
			try {
				// crear el vector que vamos a devolver
				Vector<Horario> vectorFechasSalasFisicas = new Vector<Horario>();
				
				// hacer sentencia sql select todas las reservas de la sala que queremos
				String sentenciaSQL = "select * from horario where idSalaFisica= '"+idSala+"' and disponible=1 order by date(fechaHora);";
				//hacer una conexion
				BilboSKP conexion = new BilboSKP();
				ResultSet resultado = conexion.SQLQuery(sentenciaSQL);
				//hacer un bucle de cada fila que tiene el resultset
				while (resultado.next()) {
					//obtener los campos de cada columna para esta fila
					String idSalaFisica = resultado.getString("idSalaFisica");
					Timestamp  fechaHora = resultado.getTimestamp ("fechaHora");
					boolean disponible = resultado.getBoolean("disponible");

					Horario horario = new Horario(idSalaFisica, fechaHora, disponible);
					//agregar horario al vector
					vectorFechasSalasFisicas.add(horario);
				}
				
				//hacer syso de los horarios obtenidos
				System.out.println("Horarios disponibles en la sala con id "+idSala+":");
				if (vectorFechasSalasFisicas.size()>0) {
					for (int i=0;i<vectorFechasSalasFisicas.size(); i++) {
						Horario ho = vectorFechasSalasFisicas.get(i);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		                String fechaHoraString = sdf.format(ho.getFechaHora());
		                System.out.println(fechaHoraString);
						//System.out.println(HO.getFechaHora());
					}
				}
				conexion.cerrarFlujo();
				return vectorFechasSalasFisicas;
			} catch (Exception e) {
				BilboSKP.sysoError("Error en getFechasSalasFisicas");
				e.printStackTrace();
			}
			return null;
		}
	//TODO FALTA HACER CLASE CUPON
	public static Vector<Cupon> getCuponesSuscriptor(int idSuscriptor) throws Throwable {
		Vector<Cupon> vectorCupones = new Vector<Cupon>();
		// hacer sentencia sql select todas las salas
		String sentenciaSQL = "select * from cupon where idSuscriptor = "+idSuscriptor+";";
		// hacer una conexion
		BilboSKP conexion = new BilboSKP();
		//se hace una consulta sql con la conexion y se guarda en el resultset resultado
		ResultSet resultado = conexion.SQLQuery(sentenciaSQL);
		// hacer un bucle de cada fila que tiene el resultset resultado
		while (resultado.next()) {
			// obtener los campos de cada columna para esta fila
			String idCupon = resultado.getString("idCupon");
			Date fechaCaducidad = resultado.getDate("fechaCaducidad");
			String dificultad = resultado.getString("estado");
			System.out.println(idCupon);
			Cupon cupon = null; // new Cupon(idCupon,fechaCaducidad,dificultad);
			// agregar cupon al vector
			vectorCupones.add(cupon);
		}
		
		return vectorCupones;
	}
	public static Suscriptor getDatosSuscriptor(int idSuscriptor) throws Throwable {

		// hacer sentencia sql select todas las salas
		String sentenciaSQL = "select * from suscriptor where idSuscriptor = " + idSuscriptor + ";";
		// hacer una conexion
		BilboSKP conexion = new BilboSKP();
		// se hace una consulta sql con la conexion y se guarda en el resultset
		// resultado
		ResultSet resultado = conexion.SQLQuery(sentenciaSQL);
		// hacer un bucle de cada fila que tiene el resultset resultado
		resultado.next();
		// obtener los campos de cada columna para esta fila
		int telefono = resultado.getInt("telefono");
		String email = resultado.getString("email");
		String pass = resultado.getString("pass");
		String alias = resultado.getString("alias");
		String nombre = resultado.getString("nombre");
		String apellidos = resultado.getString("apellidos");
		String imagen = resultado.getString("imagen");
		int activo = resultado.getInt("activo");
		Date fech_nac = resultado.getDate("fech_nac");

		Suscriptor suscriptor = new Suscriptor(idSuscriptor, telefono, email, pass, alias, nombre, apellidos, imagen,
				activo, fech_nac);

		return suscriptor;
	}
		
    //obtener las reservas de un suscriptor de la bd
	public static Vector<Reserva> obtenerReserva(int idSuscriptor) throws Throwable {
		Vector<Reserva> reservas= new Vector<Reserva>();
		String sentenciaSQL="SELECT * FROM reserva WHERE idSuscriptor="+idSuscriptor+" order by fechaHora ";
		BilboSKP conexion = new BilboSKP();
		ResultSet resultado = conexion.SQLQuery(sentenciaSQL);
	
		while(resultado.next()) {
			 //String idSuscriptor= resultado.getString(idSuscriptor);
			 String idReserva=resultado.getString("idReserva");
			 String idSalaFisica= resultado.getString("idSalaFisica");
			 int numJugadores= resultado.getInt("numJugadores");
			 Date fechaHora= resultado.getDate("fechaHora");
			 
			 Reserva reserva= new Reserva(idReserva, idSalaFisica, numJugadores, numJugadores, fechaHora);
			 reservas.add(reserva);
		}
		
		if(reservas.size()>0){
			for (int i=0;i<reservas.size(); i++) {
				Reserva r = reservas.get(i);
				System.out.println(r.getIdReserva());
			}
			return reservas;
		}
		else {
			
		}
		return reservas;
	}
	//TODO hacer una nueva reserva de una sala física 
	public void crearReserva() {
		
	}

	//TODO cancelar una reserva dado su id 

	// este metodo va a verificar si el email y contraseña son correctos, si son
	// correctos devuelve el suscriptor.
	public static Suscriptor loginSuscriptor(String email, String pass) throws Throwable {

		// hacer sentencia sql select todas las salas
		String sentenciaSQL = "select * from suscriptor where email = '" + email + "' and pass='" + pass + "';";
		// hacer una conexion
		BilboSKP conexion = new BilboSKP();
		// se hace una consulta sql con la conexion y se guarda en el resultset
		// resultado
		ResultSet resultado = conexion.SQLQuery(sentenciaSQL);
		// hacer un if de cada fila que tiene el resultset resultado
		if (resultado.next()) {
			int telefono = resultado.getInt("telefono");
			String alias = resultado.getString("alias");
			String nombre = resultado.getString("nombre");
			String apellidos = resultado.getString("apellidos");
			String imagen = resultado.getString("imagen");
			int activo = resultado.getInt("activo");
			Date fech_nac = resultado.getDate("fech_nac");
			int idSuscriptor = resultado.getInt("idSuscriptor");

			System.out.println("se ha devuelto al menos una linea");

			Suscriptor suscriptor = new Suscriptor(idSuscriptor, telefono, email, pass, alias, nombre, apellidos,
					imagen, activo, fech_nac);
			System.out.println("Bienvenido, tu email es" + suscriptor.getEmail());
			return suscriptor;
		} else {
			System.out.println("usuario o pass incorrecto");
		}
		return null;
	}

	// metodo que pide los campos de un suscriptor y crea una suscripcion
	public static Suscriptor crearSuscripcion(String email, String pass, int telefono, String alias, String nombre,
			String apellidos, String fech_nac) throws Throwable {
		// hacer sentencia sql select todas las salas
		String sentenciaSQL = "INSERT INTO `suscriptor` (`email`, `pass`, `alias`, `nombre`, `apellidos`, `fech_nac`, `telefono`) VALUES ('"
				+ email + "', '" + pass + "', '" + alias + "', '" + nombre + "', '" + apellidos + "', '" + fech_nac
				+ "', '" + telefono + "');";
		// hacer una conexion
		BilboSKP conexion = new BilboSKP();
		// se hace una consulta sql con la conexion y se guarda en el resultset
		// resultado
		int filasAfectadas = conexion.SQLUpdate(sentenciaSQL);
		if (filasAfectadas == 1) {

			return loginSuscriptor(email, pass);

		} else {
			System.out.println("no se pudo crear suscriptor");
			return null;
		}
		
		

	}
}
