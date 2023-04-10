package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

public class DBC {
	public static final String DRIVER_MYSQL_OLD = "com.mysql.jdbc.Driver";
	public static final String DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";
	public static final String DRIVER_CON = "com.jdbc.odbc.jbc0dbc.Driver";
	protected String dbURL, driver;
	protected Connection con;
	protected Statement st;
	protected ResultSet rs;

	// ejemplo con =
	// DriverManager.getConnection(DRIVER_MYSQL,"jdbc:mysql://localhost:3306/bares","root","");
	public DBC(String driver, String dbURL, String user, String pass) throws Throwable {
		super();
		this.driver = driver;
		this.dbURL = dbURL;
		//se intenta conectar al momento de crear la conexion
		conectar(user, pass);
	}

	// conectar con la bd dado user y pass
	public boolean conectar(String user, String pass) throws Throwable {
		try {
			// conectar con el sgbd seleccionado variable driver
			// 1.Cargar el driver a traves del cargador de clases
			Class.forName(driver);

			// 2. Usar drivermanager para la conexión, en caso de que el driver sea
			// DRIVER_MYSQL se realiza de una forma, esto hace reutilizable en caso de que
			// sea otro driver
			switch (driver) {
			case DRIVER_MYSQL:
				con = DriverManager.getConnection("jdbc:mysql://" + this.dbURL, user, pass);
				pass = null;
				break;
			default:
			}
			System.out.println("DBC: Connection Success");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("DBC: Connection error");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.out.println("DBC: SQL Error");
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * siempre hay que cerrar todos los flujos en orden
	 * resultset->statement->connection conectar -> abrir flujo ->cerrar flujo ->
	 * desconectar
	 */
	public void abrirFlujo() throws Throwable {
		if (st == null) {
			st = con.createStatement();
		}
	}

	/*
	 * se debe desconectar al final cuando ya no se consultará mas/ al cerrar la app
	 * al desconectar se llama el metodo de cerrar el flujo.
	 */
	public void desconectar() throws Throwable {
		cerrarFlujo();
		con.close();
		this.con = null;
	}

	public void cerrarFlujo() throws Throwable {
		rs.close();
		this.rs = null;
		st.close();
		this.st = null;
	}

	// METODO HACER CONSULTA SQL, DEVUELVE UN RESULTSET
	public ResultSet SQLQuery(String query) throws Throwable {
		try {
			abrirFlujo();
			// 4. se instancia el resultset con un statement, el cual necesita un string con
			// la sentencia sql
			rs = st.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			System.out.println("DBC: SQL QUERY ERROR");
			e.printStackTrace();
			return null;
		}
	}

	// HACER UPDATE DADO UNA SENTENCIA, DEVUELVE INT FILAS AFECTADAS
	public int SQLUpdate(String sentencia) throws Throwable {
		int filasAfectadas = 0;
		try {
			abrirFlujo();
			filasAfectadas = st.executeUpdate(sentencia);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DBC: SQL UPDATE ERROR");
		}
		return filasAfectadas;
	}

	// HACER SYSO DE UN RESULTSET.
	public static void sysoResultSet(ResultSet rs) throws Throwable {
		// informacion del paquete o metadata
		ResultSetMetaData rsmd = rs.getMetaData();
		int numColumnas = rsmd.getColumnCount();

		String cabecera = "";
		for (int i = 1; i <= numColumnas; i++) {
			cabecera += "#" + i + " " + rsmd.getColumnName(i) + " " + rsmd.getColumnTypeName(i) + " ";
		}
		System.out.println("Printing result set, cabecera:");
		System.out.println(cabecera);

		// recorrer la coleccion
		while (rs.next()) {
			String linea = "";
			for (int i = 1; i <= numColumnas; i++) {
				linea += rs.getString(i) + "|";
			}
			System.out.println(linea);
		}
	}

	// COMPROBAR LA CONEXION ACTUAL
	public boolean comprobarConexion() {
		if (con != null) {
			System.out.println("DBC: Conexión abierta");
			return true;
		}
		System.out.println("DBC: No Hay conexión");
		return false;
	}
}
