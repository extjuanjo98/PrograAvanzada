package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Router implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idSala;
	private int capacidad;
	private ArrayList <Paquete> coleccionPaquetes;
	private  String[] conexiones= new String [3];
	
	
	public Router(String idSala, int capacidad,String conexion1,String conexion2,String conexion3) {
		super();
		this.idSala = idSala;
		this.capacidad = capacidad;
		this.coleccionPaquetes = new ArrayList <Paquete>();
		this.conexiones[0]=conexion1;
		this.conexiones[1]=conexion2;
		this.conexiones[2]=conexion3;
	}
	public Router() {
		this.idSala=null;
		this.capacidad=0;
		this.coleccionPaquetes = new ArrayList<Paquete>();
		this.conexiones=null;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public ArrayList<Paquete> getColeccionPaquetes() {
		return coleccionPaquetes;
	}
	public void setColeccionPaquetes(ArrayList<Paquete> coleccionPaquetes) {
		this.coleccionPaquetes = coleccionPaquetes;
	}
	public String getIdSala() {
		return idSala;
	}
	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}
	public String[] getConexiones() {
		return conexiones;
	}
	public void setConexiones(String[] conexiones) {
		this.conexiones = conexiones;
	}
	
	
	
}
