package com.tienda.modelo;

public class Producto {
	
	private String cliente;
    private String nombre;
    private String telefono;
    private String comentarios;
    
    //date
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	//mode
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//unit
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	//current
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Datos Cliente [Cliente ID: " + cliente + "| Nombre : " + nombre + "| Telefono: " + telefono + "| Comentario: " + comentarios + "]";
	}
    
    
    
}
