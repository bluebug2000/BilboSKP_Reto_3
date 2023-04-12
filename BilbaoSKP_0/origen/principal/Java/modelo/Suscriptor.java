package model;

import java.util.Date;

public class Suscriptor {
	private int idSuscriptor, telefono;
	private String email, pass, alias, nombre, apellidos, imagen;   ;
	private int activo;
	private Date fech_nac;
	
	public Suscriptor(int idSuscriptor, int telefono, String email, String pass, String alias, String nombre,
			String apellidos, String imagen, int activo, Date fech_nac) {
		super();
		setIdSuscriptor(idSuscriptor);
		setTelefono(telefono);
		setEmail(email);
		setPass(pass);
		setAlias(alias);
		setNombre(nombre);
		setApellidos(apellidos);
		setImagen(imagen);
		setActivo(activo);
		setFech_nac(fech_nac);
	}

	public int getIdSuscriptor() {
		return idSuscriptor;
	}

	public void setIdSuscriptor(int idSuscriptor) {
		this.idSuscriptor = idSuscriptor;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int isActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Date getFech_nac() {
		return fech_nac;
	}

	public void setFech_nac(Date fech_nac) {
		this.fech_nac = fech_nac;
	}
	
	

}

